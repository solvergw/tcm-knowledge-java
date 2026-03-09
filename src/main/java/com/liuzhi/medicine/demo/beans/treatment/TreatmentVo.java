package com.liuzhi.medicine.demo.beans.treatment;

import com.liuzhi.medicine.demo.beans.appropriate.AppropriateTechItemVo;
import com.liuzhi.medicine.demo.beans.appropriate.AppropriateTechVo;
import com.liuzhi.medicine.demo.beans.patentDrug.PatentDrugVo;
import com.liuzhi.medicine.demo.beans.prescription.PrescriptionVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 治疗方案
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class TreatmentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("处方类型（1为草药，2为中成药，3为针灸，4为熏蒸，5为保健食疗）")
    private String preType;

    @ApiModelProperty("分型")
    private String classify;

    @ApiModelProperty("处方ID")
    private Integer preId;

    @ApiModelProperty("处方名称")
    private String preName;

    @ApiModelProperty("推荐指数")
    private String recommended;


    @ApiModelProperty("草药处方")
    private PrescriptionVo prescription;

    @ApiModelProperty("草药处方明细")
    private List<TreatmentItemVo> prescriptionItems;

    @ApiModelProperty("中成药")
    private PatentDrugVo parentDrugs;

    @ApiModelProperty("针灸处方")
    private AppropriateTechVo appropriateTech;

    @ApiModelProperty("针灸处方明细")
    private List<AppropriateTechItemVo> appropriateTechItems;
}
