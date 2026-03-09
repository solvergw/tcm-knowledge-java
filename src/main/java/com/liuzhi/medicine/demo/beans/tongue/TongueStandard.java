package com.liuzhi.medicine.demo.beans.tongue;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author guowei
 */
@Getter
@Setter
public class TongueStandard implements Serializable {

    //标准值
    private String standardValue;

    //实际值
    private List<TongueActual> actualList;
}
