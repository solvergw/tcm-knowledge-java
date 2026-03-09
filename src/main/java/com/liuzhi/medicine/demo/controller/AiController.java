package com.liuzhi.medicine.demo.controller;

import com.liuzhi.medicine.demo.beans.ai.AiChatMessage;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.service.impl.KnowledgeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经络穴位接口
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/ai")
public class AiController {
    private final IKnowledgeService knowledgeService;

    public AiController(KnowledgeServiceImpl knowledgeService) {
        this.knowledgeService = knowledgeService;
    }


    /**
     * AI 对话 健康咨询
     * 示例 ai.http
     */
    @PostMapping(value = "healthCounselor")
    public Object healthCounselor(@RequestBody AiChatMessage params) throws Exception {

        return knowledgeService.postKnow("ai/chat/healthCounselor", params);
    }

}
