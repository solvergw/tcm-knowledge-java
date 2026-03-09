package com.liuzhi.medicine.demo.beans.dialog;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author guowei
 */
@Data
public class DialogOption implements Serializable {

    //
    private Integer id;
    //名称
    private String name;
    //样式(select 单选 checkbox 多选 tongue 舌象 hide 隐藏)
    private String css;
    //分值
    private BigDecimal score;
    //是否选中
    private boolean checked;
    //AI选中的
    private boolean aiChecked;

    /**
     * 下标 + 2 = 分值
     * <p>
     * 下标 名称 分值
     * 0   轻   2
     * 1   中   3
     * 2   重   4
     * 3  非常重 5
     * </p>
     */
    //二级选项
    private List<DialogOption> options;
}
