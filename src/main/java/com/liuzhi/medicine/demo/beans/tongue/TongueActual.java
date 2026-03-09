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
public class TongueActual implements Serializable {

    //实际值
    private String actualValue;

    //对比（s 标准 ↓偏高 ↓偏低 +额外的 其他）
    private String contrast;

    //分割图
    private String splitImage;

    //特征
    private String features;

    //临床意义
    private String clinicalSignificance;

    //机理分析
    private String mechanismAnalyze;

    //属性明细
    private List<String> attrs;

}
