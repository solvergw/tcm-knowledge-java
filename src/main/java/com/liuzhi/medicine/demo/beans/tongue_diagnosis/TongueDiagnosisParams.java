package com.liuzhi.medicine.demo.beans.tongue_diagnosis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author guowei
 */
@Getter
@Setter
public class TongueDiagnosisParams {
    @ApiModelProperty("业务ID")
    private String outId;

    @ApiModelProperty("舌面图")
    private String tongueTopUrl;
    @ApiModelProperty("舌下图")
    private String tongueUnderUrl;
    @ApiModelProperty("正脸图")
    private String faceUrl;

    @ApiModelProperty("舌面图")
    private String tongueTopFile;
    @ApiModelProperty("舌下图")
    private String tongueUnderFile;
    @ApiModelProperty("正脸图")
    private String faceFile;

    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("性别：0未知 1男 2女")
    private Integer sex;
    @ApiModelProperty("身高，单位cm")
    private BigDecimal height;
    @ApiModelProperty("体重，单位kg")
    private BigDecimal weight;

}
