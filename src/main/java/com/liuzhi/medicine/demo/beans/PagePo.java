package com.liuzhi.medicine.demo.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * @author guowei
 */
@Getter
@Setter
public class PagePo extends ListPo {

    //页码 默认1
    private long page = 1;

    //行数 默认10
    private long limit = 10;

}
