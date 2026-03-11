package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guowei
 */
@Data
@NoArgsConstructor
@ApiModel(value = "测评结果药品", description = "测评结果药品")
public class EvaResultMed {

    @ApiModelProperty("药品ID")
    private Integer medId;
    @ApiModelProperty("药品名称")
    private String medName;
    @ApiModelProperty("安全检测结果描述")
    private String medDesc;
    @ApiModelProperty("相反/相畏/不宜的药品")
    private List<EvaResultMed> incMeds;

}
