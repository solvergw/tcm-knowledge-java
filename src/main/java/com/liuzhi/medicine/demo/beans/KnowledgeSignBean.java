package com.liuzhi.medicine.demo.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guowei
 */
@Data
public class KnowledgeSignBean implements Serializable {
    /**
     * 知识库的appId
     */
    private String appId;
    /**
     * 知识库的token
     */
    private String token;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 数据
     */
    private Object data;
    /**
     * 数据加密
     */
    private String encryptData;
    /**
     * 签名
     */
    private String sign;

    public String toSignString() {
        return "appId=" + appId + "&token=" + token + "&timestamp=" + timestamp + "&encryptData=" + encryptData;
    }
}