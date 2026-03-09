package com.liuzhi.medicine.demo.beans.treatment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 治疗诊断
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class TreatmentDiagnoseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("疾病代码")
    private String disCode;

    @ApiModelProperty("疾病名称")
    private String disName;

    @ApiModelProperty("证型代码")
    private String synCode;

    @ApiModelProperty("证型名称")
    private String synName;

    @ApiModelProperty("标准治法代码")
    private String therapyCode;

    @ApiModelProperty("标准治法名称")
    private String therapyName;

    @ApiModelProperty("治法")
    private String therapy;

    @ApiModelProperty("分型")
    private String classify;

    @ApiModelProperty("推荐指数（大于0的蓝色）")
    private Integer recommended;
}
