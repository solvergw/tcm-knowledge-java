package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 标准功效
 * </p>
 *
 * @author guowei
 * @since 2024-08-16
 */
@Getter
@Setter
public class MedicineEffectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("功效编码")
    private String code;

    @ApiModelProperty("功效名称")
    private String name;
}
