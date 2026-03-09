package com.liuzhi.medicine.demo.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.liuzhi.medicine.demo.beans.PageVo;
import com.liuzhi.medicine.demo.beans.treatment.TreatmentDiagnoseVo;
import com.liuzhi.medicine.demo.beans.treatment.TreatmentInferVo;
import com.liuzhi.medicine.demo.beans.treatment.TreatmentPo;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.service.impl.KnowledgeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 治疗方案接口
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    private final IKnowledgeService knowledgeService;

    public TreatmentController(KnowledgeServiceImpl knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    /**
     * 获取推荐证型和其他证型
     * 示例 treatment.http
     */
    @PostMapping(value = "syndrome")
    public Object syndrome(@RequestBody TreatmentPo params) throws Exception {

        Object res = knowledgeService.postKnow("treatment/syndrome", params);
        PageVo<TreatmentDiagnoseVo> page = JSONUtil.toBean(JSONUtil.toJsonStr(res), new TypeReference<PageVo<TreatmentDiagnoseVo>>() {
        }, false);
        log.info("总数：{}，当前页{}，每页条数：{}", page.getTotal(), page.getCurrent(), page.getSize());
        return page;
    }

    /**
     * 获取推荐治法和其他治法
     * 示例 treatment.http
     */
    @PostMapping(value = "therapy")
    public Object therapy(@RequestBody TreatmentPo params) throws Exception {

        Object res = knowledgeService.postKnow("treatment/therapy", params);
        PageVo<TreatmentDiagnoseVo> page = JSONUtil.toBean(JSONUtil.toJsonStr(res), new TypeReference<PageVo<TreatmentDiagnoseVo>>() {
        }, false);
        log.info("总数：{}，当前页{}，每页条数：{}", page.getTotal(), page.getCurrent(), page.getSize());
        return page;
    }

    /**
     * 推荐治疗方案
     * 示例 treatment.http
     */
    @PostMapping(value = "infer")
    public Object infer(@RequestBody TreatmentPo params) throws Exception {

        Object res = knowledgeService.postKnow("treatment/infer", params);
        List<TreatmentInferVo> list = JSONUtil.toList(JSONUtil.toJsonStr(res), TreatmentInferVo.class);
        log.info("总数：{}", list.size());
        return list;
    }
}
