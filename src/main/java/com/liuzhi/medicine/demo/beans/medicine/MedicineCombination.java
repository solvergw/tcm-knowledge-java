package com.liuzhi.medicine.demo.beans.medicine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 中药组合
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
@ApiModel(value = "MedicineCombination对象", description = "中药组合")
public class MedicineCombination implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关系类型: 1 相似中药 , 2 常用药对")
    private Integer type;

    @ApiModelProperty("药品id,以英文逗号分隔")
    private String madId;

    @ApiModelProperty("药品名称,以中文顿号分隔")
    private String madName;

    @ApiModelProperty("功效")
    private String effect;

    @ApiModelProperty("两种药的鉴别使用/药对释义")
    private String description;


}
