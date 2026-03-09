package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 体质辨识项目
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "ConstitutionObject对象", description = "体质辨识项目")
public class ConstitutionObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("项目ID")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String name;

    @ApiModelProperty("序号")
    private Integer sortNo;

    @ApiModelProperty("分数")
    private Integer score;

    @ApiModelProperty("选项")
    private List<ConstitutionOption> options;
}
