package com.liuzhi.medicine.demo.controller;

import cn.hutool.json.JSONUtil;
import com.liuzhi.medicine.demo.beans.dialog.DialogPo;
import com.liuzhi.medicine.demo.beans.dialog.DialogQuestion;
import com.liuzhi.medicine.demo.beans.dialog.DialogVo;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.service.impl.KnowledgeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import static com.liuzhi.medicine.demo.utils.FileUtils.fileToBase64;

/**
 * @author guowei
 */
@Slf4j
@RestController
@RequestMapping("/test2")
public class Test2Controller {
    private final IKnowledgeService knowledgeService;

    public Test2Controller(KnowledgeServiceImpl knowledgeService) {
        this.knowledgeService = knowledgeService;
    }




    /**
     * 请求健康会话
     * 示例 {@link  "com.liuzhi.medicine.demo.controller.test_dialog1-1.http"}
     */
    @PostMapping(value = "dialog")
    public Object dialog(@RequestBody DialogPo params) throws Exception {
//        BasicInfo basicInfo = new BasicInfo();
//        basicInfo.setAge(33);
//        basicInfo.setSex("1");
//        basicInfo.setHeight(170.0F);
//        basicInfo.setWeight(70.0F);
//
//        IndexInfo indexInfo = new IndexInfo();
//        ArrayList<DialogQuestion> questions = new ArrayList<>();
//
//        params.setDialogId("your_business_id");
//        params.setBasicInfo(basicInfo);
//        params.setIndexInfo(indexInfo);
//        params.setQuestions(questions);

        params.setImgUseStream(true);
        params.getQuestions().get(0).setTongueImgFile(fileToBase64("static/tongue.jpg"));
        params.getQuestions().get(0).setTongueBackImgFile(fileToBase64("static/tongueBack.jpg"));
        params.getQuestions().get(0).setFaceImgFile(fileToBase64("static/face_main.jpg"));
        Object res = knowledgeService.postKnow("healthManager/dialog", params);

        DialogVo vo = JSONUtil.toBean(JSONUtil.toJsonStr(res), DialogVo.class);

        if (!vo.isOver()) {

            //对话后面的问题
            List<DialogQuestion> nextQuestions = vo.getNextQuestions();

            log.info("接下来的问题：{}", JSONUtil.toJsonStr(nextQuestions));

            for (DialogQuestion nextQuestion : nextQuestions) {
                //舌面诊断结果
                if ("tongue_result".equals(nextQuestion.getClassify())) {
                    //保存舌面结果
                    log.info("舌面诊断结果：{}", JSONUtil.toJsonStr(nextQuestion));
                }
                //疾病结果
                else if ("disease_result".equals(nextQuestion.getClassify())) {
                    //保存疾病结果
                    log.info("舌面诊断结果：{}", JSONUtil.toJsonStr(nextQuestion));
                }
            }
        } else {
            //对话结束，出来报告
            if ("report".equals(vo.getClassify())) {
                //对话完成后的文字描述
                String content = vo.getContent();
                //舌象
                String tongue = vo.getTongue();

                log.info("报告内容：{}, 舌象结果：{}", content, tongue);
            }
        }
        //处理你的逻辑
        return vo;
    }


}
