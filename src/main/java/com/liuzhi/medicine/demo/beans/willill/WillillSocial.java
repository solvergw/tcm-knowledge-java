package com.liuzhi.medicine.demo.beans.willill;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 基于生理、心理、社会功能的欲病分类
 * </p>
 *
 * @author guowei
 * @since 2024-07-01
 */
@Getter
@Setter
public class WillillSocial implements Serializable {

    //代码
    private String code;

    //名称
    private String name;

    //描述
    private String description;

    //备注
    private String remarks;


}
