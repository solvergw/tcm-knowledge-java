package com.liuzhi.medicine.demo.beans.dialog;

import com.liuzhi.medicine.demo.beans.constitution.ConstitutionGroup;
import com.liuzhi.medicine.demo.beans.constitution.ConstitutionGroupVo;
import com.liuzhi.medicine.demo.beans.diagnose.DiagnoseSyndrome;
import com.liuzhi.medicine.demo.beans.factor.FactorItem;
import com.liuzhi.medicine.demo.beans.willill.WillillDegree;
import com.liuzhi.medicine.demo.beans.willill.WillillFunction;
import com.liuzhi.medicine.demo.beans.willill.WillillState;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author guowei
 */
@Data
public class DialogVo implements Serializable {

    //一次对话的唯一标识
    private String dialogId;

    //会话是否结束
    private boolean over = true;

    //类型（tongue舌象 tongue_result舌象结果 disease疾病 disease_result疾病结果 symptom症状 report分析报告）
    private String classify;

    //内容
    private String content;

    //对话问题
    private List<DialogQuestion> nextQuestions;

    /***问卷完后后的汇总信息***/
    @ApiModelProperty("患者选择的症状集合")
    private List<DialogOption> selectedSymptoms;

    //患者选择的症状
    private String yourSymptoms;

    //AI联想症状
    private String aiSymptoms;

    //主要不适症状
    private String worst;

    //持续时间
    private String period;

    //影响程度
    private String impact;

    /***健康状态***/
    //欲病状态
    private WillillState willillState;

    //欲病程度
    private WillillDegree willillDegree;

    //欲病功能状态
    private WillillFunction willillFunction;

    //体质
    private List<ConstitutionGroup> constitutions;

    @ApiModelProperty("体质2")
    private List<ConstitutionGroupVo> constitutionVos;

    @ApiModelProperty("体质结果")
    private String constitutionResult;

    //证素
    private List<FactorItem> factors;

    //证型
    private List<DiagnoseSyndrome> syndromes;

    /*** 舌面象 ***/
    //舌象
    private String tongue;

    //面象
    private String face;

    @ApiModelProperty("异步返回的舌面象结果")
    private DialogQuestion tongueFaceResult;

    @ApiModelProperty("扩展流程数据")
    private Map<String, Object> extendFlowData;
}
