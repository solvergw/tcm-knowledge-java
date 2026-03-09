package com.liuzhi.medicine.demo.beans.prescription;

import com.liuzhi.medicine.demo.beans.PagePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guowei
 */
@Getter
@Setter
public class PrescriptionPo extends PagePo {

    @ApiModelProperty("类别ID")
    private Integer categoryId;

    @ApiModelProperty("功效")
    private String effect;

}
