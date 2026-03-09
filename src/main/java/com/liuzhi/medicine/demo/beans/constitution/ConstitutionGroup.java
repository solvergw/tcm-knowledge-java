package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

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
public class ConstitutionGroup implements Serializable {

    @ApiModelProperty("分组ID")
    private Integer id;

    //分组名称
    private String name;

    //定义
    private String definition;

    //总体特征
    private String generalCharacteristics;

    //形体特征
    private String physicalCharacteristics;

    //心理特征
    private String psychicCharacteristics;

    //常见表现
    private String commonManifestations;

    //发病倾向
    private String diseaseTendency;

    //对外界环境适应能力
    private String adaptability;

    //调体原则
    private String principle;

    //分组描述
    private String description;

    //备注
    private String remarks;

    @ApiModelProperty("选项")
    private List<ConstitutionObject> objects;
}
