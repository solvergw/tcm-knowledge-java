package com.liuzhi.medicine.demo.service;

/**
 * 调用知识库服务
 * @author guowei
 */
public interface IKnowledgeService {
    Object postKnow(String method, Object data) throws Exception;
}
