package com.liuzhi.medicine.demo.beans.diagnose;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 证型
 * </p>
 *
 * @author guowei
 * @since 2022-10-20
 */
@Getter
@Setter
public class DiagnoseSyndrome implements Serializable {

    private Integer id;

    //证型编码
    private String code;

    //证型名称
    private String name;

    //证候分析
    private String analysis;

    //备注
    private String remarks;
}
