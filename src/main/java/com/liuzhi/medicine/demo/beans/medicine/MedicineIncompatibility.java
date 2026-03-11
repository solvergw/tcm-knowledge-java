package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药配伍禁忌
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineIncompatibility对象", description = "中药配伍禁忌")
public class MedicineIncompatibility implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("药品ID")
    private Integer madId;

    @ApiModelProperty("药品名称1")
    private String madName;

    @ApiModelProperty("相反或相畏的药品ID")
    private Integer madIncId;

    @ApiModelProperty("药品名称2")
    private String madIncName;

    @ApiModelProperty("类型 1-十八反；2-十九畏；3为不宜")
    private Integer incType;

}
