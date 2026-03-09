package com.liuzhi.medicine.demo.beans.conditioning;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 调理方案
 * </p>
 *
 * @author guowei
 * @since 2024-07-01
 */
@Getter
@Setter
public class ConditioningProgram implements Serializable {

    //名称
    private String name;

    //类型
    private String classifyName;

    //描述
    private String description;

    //备注
    private String remarks;

    //属性
    private List<ConditioningProgramAttr> attrList;

    //明细
    private List<ConditioningProgramItem> itemList;

}
