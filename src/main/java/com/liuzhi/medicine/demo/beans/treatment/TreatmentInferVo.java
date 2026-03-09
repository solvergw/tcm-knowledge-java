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
import java.util.Map;

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
public class TreatmentInferVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("方案类型（1为草药，2为中成药，3为针灸，5为保健食疗）")
    private String preType;

    @ApiModelProperty("治疗方案")
    private List<TreatmentVo> treatments;
}
