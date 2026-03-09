package com.liuzhi.medicine.demo.beans.treatment;

import com.liuzhi.medicine.demo.beans.ListPo;
import com.liuzhi.medicine.demo.beans.PagePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guowei
 */
@Getter
@Setter
public class TreatmentPo extends PagePo {

    @ApiModelProperty("疾病代码")
    private String disCode;

    @ApiModelProperty("证型代码")
    private String synCode;

    @ApiModelProperty("标准治法代码")
    private String therapyCode;

    @ApiModelProperty("治法")
    private String therapy;

    @ApiModelProperty("分型")
    private String classify;

    @ApiModelProperty("处方类型（1为草药，2为中成药，3为针灸，4为熏蒸，5为保健食疗）")
    private String preType;

}
