package com.liuzhi.medicine.demo.beans.pulse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 脉象
 * </p>
 *
 * @author guowei
 * @since 2025-12-04
 */
@Getter
@Setter
@ApiModel(value = "PulseCondition对象", description = "脉象")
public class PulseCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("拼音")
    private String py;

    @ApiModelProperty("五笔")
    private String wb;

    @ApiModelProperty("分类")
    private String classify;

    @ApiModelProperty("图片")
    private String imageUrl;

    @ApiModelProperty("书籍")
    private String bookName;

    @ApiModelProperty("页码")
    private String pageInfo;

    @ApiModelProperty("定义")
    private String feature;

    @ApiModelProperty("临床意义")
    private String signality;

    @ApiModelProperty("正常此脉")
    private String pulseNormal;

    @ApiModelProperty("体状诗")
    private String bitStatusPoem;

    @ApiModelProperty("相类诗")
    private String similarPoem;

    @ApiModelProperty("主病诗")
    private String primaryDisPoem;

    @ApiModelProperty("时珍论注")
    private String discuss;
}
