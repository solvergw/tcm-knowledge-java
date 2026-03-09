package com.liuzhi.medicine.demo.beans.appropriate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 适宜技术明细
 * </p>
 *
 * @author guowei
 * @since 2024-07-16
 */
@Getter
@Setter
public class AppropriateTechItemVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("明细类型（medicine中药 acupoint穴位 meridian经络）")
    private String itemType;

    @ApiModelProperty("明细ID")
    private Integer itemId;

    @ApiModelProperty("明细名称")
    private String itemName;

    @ApiModelProperty("剂量")
    private String dose;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("图片")
    private String photo;
}
