package com.liuzhi.medicine.demo.beans.patentDrug;

import com.liuzhi.medicine.demo.beans.PagePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guowei
 */
@Getter
@Setter
public class PatentDrugPo extends PagePo {

    @ApiModelProperty("一级类别ID")
    private Integer categoryId;

    @ApiModelProperty("功能主治")
    private String indication;

}
