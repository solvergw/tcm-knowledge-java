package com.liuzhi.medicine.demo.beans.appropriate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 适宜技术
 * </p>
 *
 * @author guowei
 * @since 2024-07-16
 */
@Getter
@Setter
public class AppropriateTechVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("类型")
    private String classify;

    @ApiModelProperty("功效")
    private String effect;

    @ApiModelProperty("组成")
    private String constituent;

    @ApiModelProperty("部位")
    private String position;

    @ApiModelProperty("主穴")
    private String mainAcupoint;

    @ApiModelProperty("配穴")
    private String subAcupoint;

    @ApiModelProperty("操作")
    private String operation;

    @ApiModelProperty("疗程说明")
    private String treatmentCourse;

    @ApiModelProperty("使用注意")
    private String notes;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("明细")
    private List<AppropriateTechItemVo> itemList;
}
