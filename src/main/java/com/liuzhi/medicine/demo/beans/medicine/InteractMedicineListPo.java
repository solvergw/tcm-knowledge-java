package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author guowei
 */
@Data
@ApiModel(value = "测评药品列表", description = "测评药品列表")
public class InteractMedicineListPo {

    @ApiModelProperty("药品列表")
    private List<InteractMedicinePo> medList;

    @ApiModelProperty("是否怀孕：Y为怀孕，N为没有怀孕")
    private String gravidity;
    @ApiModelProperty("性别 M男F女")
    private String gender;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("疾病ID")
    private String disId;
    @ApiModelProperty("证型ID")
    private String synId;
}
