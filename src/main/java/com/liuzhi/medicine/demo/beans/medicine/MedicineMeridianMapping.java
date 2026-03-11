package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药归经关系表
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineMeridianMapping对象", description = "中药归经关系表")
public class MedicineMeridianMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("归经ID")
    private Integer meridianId;

    @ApiModelProperty("归经名称")
    private String meridianName;

}
