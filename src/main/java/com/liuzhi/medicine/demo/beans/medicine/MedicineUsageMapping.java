package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药用法关系表
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineUsageMapping对象", description = "中药用法关系表")
public class MedicineUsageMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用法ID")
    private Integer usageId;

    @ApiModelProperty("用法名")
    private String usageName;

}
