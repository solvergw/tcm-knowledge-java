package com.liuzhi.medicine.demo.beans.conditioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class ConditioningProgramClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    //类型名称
    private String name;

    //调理方案
    private List<ConditioningProgram> programList;

}
