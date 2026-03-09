# tcm-knowledge-java

杭州六智科技有限公司中医知识库（Knowledge）Java 接口示例项目。

> 本项目是一个基于 Spring Boot 的「接口调用示例」，核心目标是演示如何完成：
> 1) 获取知识库 token；2) 按签名规范封装请求；3) 调用六智中医知识库各业务接口。

## 项目简介

- 技术栈：Spring Boot 2.0.5、Java 8、RestTemplate、Lombok、Hutool、Fastjson。
- 认证机制：`appId + appPwd` 获取 token，业务请求携带 `appId/token/timestamp/data/encryptData/sign`。
- 签名流程：
    - 对 `data` 做参数拼接（`ParamsUtils.linkParam`）并进行 `SHA-256`；
    - 使用 RSA 公钥加密签名串（`KnowledgeSignBean#toSignString`）；
    - 将签名结果作为 `sign` 发送到知识库服务。

## 目录结构

```text
src/main/java/com/liuzhi/medicine/demo
├── controller                # 示例接口入口（治疗方案、舌诊、AI 对话、调理方案等）
├── service                   # 统一请求服务接口
├── service/impl              # 知识库请求实现（token 获取、签名、转发）
├── properties                # 配置映射（knowledge.*）
├── encrypt                   # RSA 加解密工具
├── beans                     # 请求/响应模型
├── utils                     # 参数拼接、Base64、文件读取等工具
└── KnowledgeJavaApplication  # 启动类

src/main/resources
├── application.yml           # 本地配置模板
└── static                    # 示例图片（舌面/舌下/面象）
```

## 环境要求

- JDK 1.8+
- Maven 3.6+
- 可访问六智知识库测试环境：`https://dev.hzliuzhi.com:62006/knowledge/`

## 快速开始

### 1. 获取接入信息

请联系杭州六智科技有限公司获取以下参数：

- `knowledge.appId`
- `knowledge.appPwd`
- `knowledge.rsaPublicKey`

### 2. 配置 `application.yml`

编辑 `src/main/resources/application.yml`：

```yaml
server:
  port: 8080
knowledge:
  appId: 你的应用ID
  appPwd: 你的应用密码
  # 测试环境（建议先在该环境联调）
  urlPrefix: https://dev.hzliuzhi.com:62006/knowledge/
  rsaPublicKey: 你的RSA公钥
```

### 3. 启动项目

```bash
mvn spring-boot:run
```

或打包后运行：

```bash
mvn clean package -DskipTests
java -jar target/tcm-knowledge-java-0.0.1-SNAPSHOT.jar
```

## 接口示例（本地代理接口）

以下接口由本项目提供，内部会转发到知识库真实服务。

### 1) 治疗方案（`/treatment`）

- `POST /treatment/syndrome`：获取推荐证型和其他证型
- `POST /treatment/therapy`：获取推荐治法和其他治法
- `POST /treatment/infer`：推荐治疗方案

示例请求见：`src/main/java/com/liuzhi/medicine/demo/http/treatment.http`

### 2) 舌面象诊断（`/tongueDiagnosis`）

- `POST /tongueDiagnosis/syncByUrl`：上传图片 URL 进行诊断
- `POST /tongueDiagnosis/syncByBase64`：上传 Base64（示例读取本地 `static` 图片）

示例请求见：`src/main/java/com/liuzhi/medicine/demo/http/tongueDiagnosis.http`

### 3) AI 健康咨询（`/ai`）

- `POST /ai/healthCounselor`：AI 对话健康咨询

### 4) 健康会话与调理方案（示例接口）

- `POST /test/dialog`：健康会话示例
- `POST /test/conditioning`：获取调理方案示例
- `POST /test2/dialog`：健康会话（图片流/BASE64 方式）示例
- `POST /conditioningProgram/conditioning`：根据健康分析报告获取调理方案
- `POST /conditioningProgram/list`：调理方案搜索

## 调用流程说明

1. `KnowledgeServiceImpl#getKnowledgeToken()` 自动请求：
    - `GET /sys/app/token?appId=...&appPwd=...`
2. token 即将过期（<1分钟）时自动刷新。
3. 业务请求调用 `KnowledgeServiceImpl#postKnow(method, data)`：
    - 组装签名对象 `KnowledgeSignBean`
    - 计算 `encryptData`（SHA-256）
    - 生成 `sign`（RSA）
    - 发送 `POST {knowledge.urlPrefix}{method}`
4. 统一解析 `RespEntity`，成功返回 `data` 字段。

## 常见问题

### 1. 启动后调用接口报鉴权错误？

优先检查：
- `appId/appPwd` 是否正确；
- `rsaPublicKey` 是否与平台分配一致；
- 服务器系统时间是否准确（签名包含时间戳）。

### 2. 图片上传示例如何替换为业务图片？

- URL 模式：传公网可访问图片地址；
- Base64 模式：将业务系统图片转 Base64 后赋值到请求字段。

### 3. 为什么项目里有 `/test` 与 `/test2`？

它们用于演示健康会话及图片传参与结果处理逻辑，便于业务二次开发时参考。

## 开发建议

- 生产环境建议将 token 做分布式缓存，减少频繁获取。
- `classifyOrder`（调理方案分类顺序）建议迁移至字典/配置中心。
- 对上游调用增加超时与重试策略，并按业务做错误码映射。

## 许可证

本项目采用 `LICENSE` 文件中声明的许可证。
