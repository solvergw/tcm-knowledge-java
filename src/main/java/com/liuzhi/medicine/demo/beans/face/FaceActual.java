package com.liuzhi.medicine.demo.beans.face;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guowei
 */
@Getter
@Setter
public class FaceActual implements Serializable {

    @ApiModelProperty("实际值")
    private String actualValue;

    @ApiModelProperty("对比（s标准 ↓偏高 ↓偏低 +额外的 r标红）")
    private String contrast;

    @ApiModelProperty("分割图")
    private String splitImage;

    @ApiModelProperty("特征")
    private String features;

}
