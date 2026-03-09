package com.liuzhi.medicine.demo.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guowei
 */
@Getter
@Setter
public class ListPo implements Serializable {

    //搜索关键字
    private String keyWord;

    //搜索类型（1：拼音，2：五笔，3：中文）
    private String searchType;

}
