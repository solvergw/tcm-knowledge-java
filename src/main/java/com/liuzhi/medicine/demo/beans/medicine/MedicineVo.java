package com.liuzhi.medicine.demo.beans.medicine;

import com.liuzhi.medicine.demo.beans.AttributeVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 中药
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class MedicineVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("中药ID")
    private Integer id;

    @ApiModelProperty("中药代码")
    private String code;

    @ApiModelProperty("中药标准名称")
    private String name;

    @ApiModelProperty("最小用量")
    private BigDecimal minDosage;

    @ApiModelProperty("最大用量")
    private BigDecimal maxDosage;

    @ApiModelProperty("生品ID")
    private Integer rawMadId;

    @ApiModelProperty("生品")
    private String rawMad;

    @ApiModelProperty("图片路径")
    private String photo;

    @ApiModelProperty("吸水系数（mL/g）")
    private BigDecimal absorptionCoefficient;


    @ApiModelProperty("中药服用禁忌")
    private MedicineTaboo taboo;

    @ApiModelProperty("关联中药性味")
    private List<MedicineFlavourMapping> flavourMappings;

    @ApiModelProperty("关联中药归经")
    private List<MedicineMeridianMapping> meridianMappings;

    @ApiModelProperty("中药配伍禁忌")
    private List<MedicineIncompatibility> incompatibilities;

    @ApiModelProperty("关联中药用法")
    private List<MedicineUsageMapping> usageMappings;

    @ApiModelProperty("关联中药标准功效关")
    private List<MedicineEffectMapping> effectMappings;

    @ApiModelProperty("中药组合")
    private List<MedicineCombination> combinations;

    @ApiModelProperty("十八反药品ID")
    private List<Integer> sbfIds;

    @ApiModelProperty("十九畏药品ID")
    private List<Integer> sjwIds;

    @ApiModelProperty("不宜药品ID")
    private List<Integer> byIds;

    @ApiModelProperty("属性说明")
    private List<AttributeVo> attributes;

}
