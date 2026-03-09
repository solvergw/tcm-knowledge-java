package com.liuzhi.medicine.demo.controller;

import cn.hutool.json.JSONUtil;
import com.liuzhi.medicine.demo.beans.conditioning.ConditioningProgram;
import com.liuzhi.medicine.demo.beans.conditioning.ConditioningProgramClassify;
import com.liuzhi.medicine.demo.beans.dialog.DialogVo;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.service.impl.KnowledgeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/conditioningProgram")
public class ConditioningProgramController {

    private final IKnowledgeService knowledgeService;

    public ConditioningProgramController(KnowledgeServiceImpl knowledgeService) {
        this.knowledgeService = knowledgeService;
    }


    /**
     * 根据健康分析报告获取调理方案
     * 示例 test_conditioning.http
     */
    @PostMapping(value = "conditioning")
    public Object conditioning(@RequestBody DialogVo params) throws Exception {

        Object res = knowledgeService.postKnow("healthManager/conditioning", params);

        List<ConditioningProgram> voList = JSONUtil.toList(JSONUtil.toJsonStr(res), ConditioningProgram.class);

        Map<String, List<ConditioningProgram>> classifyMap = voList.stream().collect(Collectors.groupingBy(ConditioningProgram::getClassifyName));

        //调理方案分类顺序，建议使用字典配置
        List<String> classifyOrder = Arrays.asList(
                "起居调摄",
                "情志调摄",
                "音乐调摄",
                "形体运动",
                "保健功法",
                "饮食调养",
                "药膳推荐",
                "茶饮推荐",
                "穴位按摩",
                "艾灸",
                "耳穴按摩",
                "耳穴压豆",
                "足浴",
                "中药调理",
                "中成药调理",
                "拔罐",
                "刮痧",
                "刺血拔罐",
                "针刺疗法",
                "穴位敷贴",
                "穴位刺激调控疗法",
                "耳针",
                "中药熏蒸",
                "中药烫熨",
                "中药香囊",
                "膏方调理",
                "穴位注射",
                "心理疗法");


        List<ConditioningProgramClassify> classifyList = classifyOrder.stream()
                .filter(classifyMap::containsKey)
                .map(classify -> new ConditioningProgramClassify(classify, classifyMap.get(classify)))
                .collect(Collectors.toList());

        log.info("调理方案：{}", classifyList);
        return classifyList;
    }

    /**
     * 搜索调理方案
     * 示例 {@link  "com.liuzhi.medicine.demo.controller.test_conditioning.http"}
     */
    @PostMapping(value = "list")
    public Object list(@RequestBody ConditioningProgram params) throws Exception {

        Object res = knowledgeService.postKnow("conditioning/conditioningProgram/list", params);

        List<ConditioningProgram> voList = JSONUtil.toList(JSONUtil.toJsonStr(res), ConditioningProgram.class);

        log.info("调理方案：{}", voList);
        return voList;
    }
}
