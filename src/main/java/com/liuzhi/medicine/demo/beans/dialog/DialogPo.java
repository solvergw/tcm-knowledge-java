package com.liuzhi.medicine.demo.beans.dialog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guowei
 */
@Data
public class DialogPo implements Serializable {
    //一次对话的唯一标识
    private String dialogId;
    //基本信息
    private BasicInfo basicInfo;
    //指标信息
    private IndexInfo indexInfo;
    //问题集合
    private List<DialogQuestion> questions;
    @ApiModelProperty("是否批量提问")
    private boolean batchQuestion;
    @ApiModelProperty("是否异步等待舌诊结果")
    private boolean asyncTongueResult = false;
    @ApiModelProperty("图片使用文件流传参")
    private boolean imgUseStream = false;
    @ApiModelProperty("扩展流程（alcohol 饮酒量）")
    private String extendFlow;
}
