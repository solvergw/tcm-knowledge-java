package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药服用禁忌
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineTaboo对象", description = "中药服用禁忌")
public class MedicineTaboo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("中药ID")
    private Integer madId;

    @ApiModelProperty("慎忌禁")
    private String taboo;

    @ApiModelProperty("孕妇慎忌禁")
    private String pregnantTaboo;

    @ApiModelProperty("病证禁忌")
    private String disSyn;

    @ApiModelProperty("服药饮食禁忌")
    private String diet;

    @ApiModelProperty("毒性说明")
    private String toxicity;

    @ApiModelProperty("肝肾功能障碍患者服用禁忌")
    private String hepatorenal;

    @ApiModelProperty("长期或大量服用损伤")
    private String large;

    @ApiModelProperty("生理期内女性服用禁忌")
    private String period;

    @ApiModelProperty("育龄期妇女服用禁忌")
    private String childbearingAge;

    @ApiModelProperty("哺乳期妇女服用禁忌")
    private String lactation;

    @ApiModelProperty("儿童服用禁忌")
    private String children;

    @ApiModelProperty("老人服用禁忌")
    private String elderly;

    @ApiModelProperty("慢病患者服用禁忌")
    private String chronicDisease;

    @ApiModelProperty("过敏体质服用禁忌")
    private String allergic;

    @ApiModelProperty("低血压、低血糖患者服用禁忌")
    private String hypotensionHypoglycemia;

    @ApiModelProperty("运动员服用禁忌")
    private String athletes;

    @ApiModelProperty("出血性患者服用禁忌")
    private String bleeding;

    @ApiModelProperty("使用注意")
    private String notes;


}
