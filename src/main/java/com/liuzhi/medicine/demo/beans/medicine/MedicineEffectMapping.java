package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药标准功效关系表
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineEffectMapping对象", description = "中药标准功效关系表")
public class MedicineEffectMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标准功效ID")
    private Integer effectId;

    @ApiModelProperty("标准功效名称")
    private String effectName;

}
