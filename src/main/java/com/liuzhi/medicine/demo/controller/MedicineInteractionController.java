package com.liuzhi.medicine.demo.controller;

import cn.hutool.json.JSONUtil;
import com.liuzhi.medicine.demo.beans.medicine.EvaResult;
import com.liuzhi.medicine.demo.beans.medicine.InteractMedicineListPo;
import com.liuzhi.medicine.demo.beans.medicine.MedicineVo;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/medicineInteraction")
@RequiredArgsConstructor
public class MedicineInteractionController {
    private final IKnowledgeService knowledgeService;


    /**
     * 药品测评
     * 示例 medicine.http
     */
    @PostMapping(value = "medicine")
    public Object interactionMedicine(@RequestBody InteractMedicineListPo params) throws Exception {

        Object res = knowledgeService.postKnow("medicine/interaction/medicine", params);

        return JSONUtil.toList(JSONUtil.toJsonStr(res), MedicineVo.class);
    }

    /**
     * 测评报告
     * 示例 medicine.http
     */
    @PostMapping(value = "report")
    public Object interactionReport(@RequestBody InteractMedicineListPo params) throws Exception {

        Object res = knowledgeService.postKnow("medicine/interaction/report", params);

        return JSONUtil.toBean(JSONUtil.toJsonStr(res), EvaResult.class);
    }
}
