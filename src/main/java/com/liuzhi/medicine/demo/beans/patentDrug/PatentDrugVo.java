package com.liuzhi.medicine.demo.beans.patentDrug;

import com.liuzhi.medicine.demo.beans.AttributeVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 中成药
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class PatentDrugVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("中成药ID")
    private Integer id;

    @ApiModelProperty("中成药名称")
    private String name;

    @ApiModelProperty("功能主治")
    private String indication;

    @ApiModelProperty("属性描述")
    private List<AttributeVo> attributes;

}
