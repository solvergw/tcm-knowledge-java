package com.liuzhi.medicine.demo.beans.dialog;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guowei
 */
@Data
public class IndexInfo implements Serializable {
    //收缩压
    private BigDecimal systolicPressure;
    //舒张压
    private BigDecimal diastolicPressure;
    //体温
    private BigDecimal temperature;
    //血氧
    private BigDecimal bloodOxygen;
    //血糖
    private BigDecimal bloodGlucose;
    //血脂
    private BigDecimal bloodFat;
    //心率
    private BigDecimal heartRate;
    //尿酸
    private BigDecimal uricAcid;
    //甘油三酯
    private BigDecimal triglyceride;
    //血清总胆固醇
    private BigDecimal totalCholesterol;
    //低密度脂蛋白胆固醇
    private BigDecimal LDLCholesterol;
    //高密度脂蛋白胆固醇
    private BigDecimal HDLCholesterol;
}
