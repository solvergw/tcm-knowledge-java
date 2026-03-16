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

    @ApiModelProperty("穴位ID")
    private Integer acuId;

    @ApiModelProperty("穴位名称")
    private String acuName;
}
