package com.liuzhi.medicine.demo.controller;

import cn.hutool.json.JSONUtil;
import com.liuzhi.medicine.demo.beans.tongue_diagnosis.TongueDiagnosisParams;
import com.liuzhi.medicine.demo.beans.tongue_diagnosis.TongueDiagnosisResult;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.service.impl.KnowledgeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.liuzhi.medicine.demo.utils.FileUtils.fileToBase64;

/**
 * 治疗方案接口
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/tongueDiagnosis")
public class TongueDiagnosisController {
    private final IKnowledgeService knowledgeService;

    public TongueDiagnosisController(KnowledgeServiceImpl knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    /**
     * 同步舌面象检测（上传URL文件）
     * 示例 tongueDiagnosis.http  第一个
     */
    @PostMapping(value = "syncByUrl")
    public Object syncByUrl(@RequestBody TongueDiagnosisParams params) throws Exception {

        Object res = knowledgeService.postKnow("tongueDiagnosis/sync", params);
        TongueDiagnosisResult result = JSONUtil.toBean(JSONUtil.toJsonStr(res), TongueDiagnosisResult.class);
        log.info("结果：{}", result);
        return result;
    }

    /**
     * 同步舌面象检测（上传本地文件）
     * 示例 tongueDiagnosis.http  第二个
     */
    @PostMapping(value = "syncByBase64")
    public Object syncByBase64(@RequestBody TongueDiagnosisParams params) throws Exception {

        params.setTongueTopFile(fileToBase64("static/tongue.jpg"));
        params.setTongueUnderFile(fileToBase64("static/tongueBack.jpg"));
        params.setFaceFile(fileToBase64("static/face_main.jpg"));

        Object res = knowledgeService.postKnow("tongueDiagnosis/sync", params);
        TongueDiagnosisResult result = JSONUtil.toBean(JSONUtil.toJsonStr(res), TongueDiagnosisResult.class);
        log.info("结果：{}", result);
        return result;
    }
}
