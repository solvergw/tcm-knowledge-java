package com.liuzhi.medicine.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * 示例配置
 *
 * @author guowei
 */
@ConfigurationProperties(prefix = "knowledge")
@Data
public class KnowledgeProperties {

    /**
     * 知识库的appId
     */
    private String appId;
    /**
     * 知识库的密码
     */
    private String appPwd;
    /**
     * 知识库的地址
     */
    private String urlPrefix;
    /**
     * RSA私钥
     */
    private String rsaPublicKey;
    /**
     * 知识库的token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date effectiveTime;
}
