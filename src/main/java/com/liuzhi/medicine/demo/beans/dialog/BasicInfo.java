package com.liuzhi.medicine.demo.beans.dialog;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guowei
 */
@Data
public class BasicInfo implements Serializable {
    //年龄
    private Integer age;

    //性别（详见字典：用户性别 0男 1女 2未知）
    private String sex;

    //身高
    private Float height;

    //体重
    private Float weight;

    //食物过敏（详见字典：食物过敏）
    private String foodAllergy;

    //喜好口味（详见字典：喜好口味）
    private String hobbyFlavor;

    //饮酒情况（详见字典：系统是否）
    private String drinkState;

    //吸烟情况（详见字典：系统是否）
    private String smokeState;

    //女性特殊期（详见字典：女性特殊期）
    private String womenSpecialPeriod;

    //职业（详见字典：职业）
    private String job;

}
