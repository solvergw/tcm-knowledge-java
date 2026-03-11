package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guowei
 */
@Data
@ApiModel(value = "测评结果", description = "测评结果")
public class EvaResult implements Serializable {

    @ApiModelProperty("剂量超标")
    private List<EvaResultMed> overDose;
    @ApiModelProperty("剂量偏低")
    private List<EvaResultMed> lowDose;

    @ApiModelProperty("慎忌禁用药")
    private List<EvaResultMed> taboo;
    @ApiModelProperty("孕妇慎忌禁用药")
    private List<EvaResultMed> pregnantTaboo;

    @ApiModelProperty("服药饮食禁忌")
    private List<EvaResultMed> diet;
    @ApiModelProperty("药物毒性说明")
    private List<EvaResultMed> toxicity;
    @ApiModelProperty("病证用药禁忌")
    private List<EvaResultMed> disSyn;

    @ApiModelProperty("十八反")
    private List<EvaResultMed> sbf;
    @ApiModelProperty("十九畏")
    private List<EvaResultMed> sjw;
    @ApiModelProperty("用药不宜")
    private List<EvaResultMed> by;
    @ApiModelProperty("炮制品")
    private List<EvaResultMed> prepare;


    public EvaResult() {
        this.overDose = new ArrayList<>();
        this.lowDose = new ArrayList<>();
        this.taboo = new ArrayList<>();
        this.pregnantTaboo = new ArrayList<>();
        this.diet = new ArrayList<>();
        this.toxicity = new ArrayList<>();
        this.disSyn = new ArrayList<>();
        this.sbf = new ArrayList<>();
        this.sjw = new ArrayList<>();
        this.by = new ArrayList<>();
    }
}
