package com.liuzhi.medicine.demo.beans.treatment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 治疗方案明细
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class TreatmentItemVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("药品ID")
    private Integer madId;

    @ApiModelProperty("药名")
    private String madName;

    @ApiModelProperty("剂量")
    private BigDecimal dose;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("用法")
    private String direction;

}
