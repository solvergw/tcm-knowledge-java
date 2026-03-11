package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药性味关系表
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineFlavourMapping对象", description = "中药性味关系表")
public class MedicineFlavourMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("性味ID")
    private Integer flavourId;

    @ApiModelProperty("性味名称")
    private String flavourName;

}
