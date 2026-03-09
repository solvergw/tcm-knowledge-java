package com.liuzhi.medicine.demo.beans.conditioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
@NoArgsConstructor
@AllArgsConstructor
public class ConditioningProgramAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    //名称
    private String name;

    //描述
    private String description;

}
