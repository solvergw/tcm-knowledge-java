package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 体质辨识分组
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class ConstitutionGroupVo implements Serializable {

    @ApiModelProperty("代码")
    private String code;

    @ApiModelProperty("分组名称")
    private String name;

    @ApiModelProperty("定义")
    private String definition;

    @ApiModelProperty("总体特征")
    private String generalCharacteristics;

    @ApiModelProperty("形体特征")
    private String physicalCharacteristics;

    @ApiModelProperty("心理特征")
    private String psychicCharacteristics;

    @ApiModelProperty("常见表现")
    private String commonManifestations;

    @ApiModelProperty("发病倾向")
    private String diseaseTendency;

    @ApiModelProperty("对外界环境适应能力")
    private String adaptability;

    @ApiModelProperty("调体原则")
    private String principle;

    @ApiModelProperty("分组描述")
    private String description;

    @ApiModelProperty("得分")
    private BigDecimal score;

    @ApiModelProperty("基本是")
    private boolean basicTo;

    @ApiModelProperty("倾向是")
    private boolean tendTo;

}
