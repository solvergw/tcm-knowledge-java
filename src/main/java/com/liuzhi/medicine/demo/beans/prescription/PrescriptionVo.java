package com.liuzhi.medicine.demo.beans.prescription;

import com.liuzhi.medicine.demo.beans.AttributeVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 处方
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Data
public class PrescriptionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("处方ID")
    private Integer id;

    @ApiModelProperty("方剂编码")
    private String code;

    @ApiModelProperty("方剂名")
    private String name;

    @ApiModelProperty("别名")
    private String alias;

    @ApiModelProperty("一级类别名称")
    private String categoryName;

    @ApiModelProperty("二级类别名称")
    private String subCategoryName;

    @ApiModelProperty("处方用法名称")
    private String usageName;

    @ApiModelProperty("药品明细")
    private List<PrescriptionItem> itemList;

    @ApiModelProperty("属性描述")
    private List<AttributeVo> attributes;

}
