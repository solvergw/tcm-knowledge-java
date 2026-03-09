package com.liuzhi.medicine.demo.beans.tongue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author guowei
 * @since 2024-07-22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TongueInfo对象", description = "系统舌象")
public class TongueInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("拼音")
    private String py;

    @ApiModelProperty("五笔")
    private String wb;

    @ApiModelProperty("主分类")
    private String primaryClassify;

    @ApiModelProperty("次分类")
    private String secondaryClassify;

    @ApiModelProperty("特征")
    private String features;

    @ApiModelProperty("临床意义")
    private String clinicalSignificance;

    @ApiModelProperty("机理分析")
    private String mechanismAnalyze;

    @ApiModelProperty("图片")
    private String photo;

    @ApiModelProperty("书籍")
    private String book;
}
