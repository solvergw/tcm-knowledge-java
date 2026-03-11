package com.liuzhi.medicine.demo.beans.medicine;

import com.liuzhi.medicine.demo.beans.PagePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guowei
 */
@Getter
@Setter
public class MedicinePo extends PagePo {

    /**
     * 填充 MedicineEffectVo 的 id
     */
    @ApiModelProperty("标准功效ID")
    private Integer effectId;

    /**
     * 填充用户输入功效
     */
    @ApiModelProperty("功效")
    private String efficacy;

}
