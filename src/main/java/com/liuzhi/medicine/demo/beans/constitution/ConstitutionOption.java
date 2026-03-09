package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 体质辨识项目选项
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "ConstitutionOption对象", description = "体质辨识项目选项")
public class ConstitutionOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("选项ID")
    private Integer id;

    @ApiModelProperty("选项名称")
    private String name;

    @ApiModelProperty("分数")
    private Integer score;

    @ApiModelProperty("序号")
    private Integer sortNo;


}
