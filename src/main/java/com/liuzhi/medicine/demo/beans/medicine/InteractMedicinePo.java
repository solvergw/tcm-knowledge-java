package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author guowei
 */
@Data
@ApiModel(value = "测评药品", description = "测评药品")
public class InteractMedicinePo implements Serializable {

    @ApiModelProperty("药品id")
    private Integer medId;
    @ApiModelProperty("药品名称")
    private String medName;
    @ApiModelProperty("药品剂量")
    private String medDose;
    @ApiModelProperty("药品单位")
    private String medUnit;
    @ApiModelProperty("药品用法")
    private String medUsage;

}
