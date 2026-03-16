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

    @ApiModelProperty("针灸处方ID")
    private Integer id;

    @ApiModelProperty("疾病名称")
    private String disName;

    @ApiModelProperty("辨证要点")
    private String acuMethod;

    @ApiModelProperty("治法")
    private String therapy;

    @ApiModelProperty("分型")
    private String classify;

    @ApiModelProperty("主穴")
    private String mainAcupoint;

    @ApiModelProperty("配穴")
    private String subAcupoint;

    @ApiModelProperty("方义")
    private String mechanismPre;

    @ApiModelProperty("操作")
    private String operation;

    @ApiModelProperty("其他治疗")
    private String otherTreatments;

    @ApiModelProperty("按语")
    private String footnotes;

    @ApiModelProperty("业务类型（1为针灸，2为艾灸，3为推拿，4为拔罐）")
    private String bussinessType;

    @ApiModelProperty("明细")
    private List<AppropriateTechItemVo> itemList;
}
