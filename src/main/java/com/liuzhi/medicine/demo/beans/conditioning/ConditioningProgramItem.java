package com.liuzhi.medicine.demo.beans.conditioning;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 调理方案明细
 * </p>
 *
 * @author guowei
 * @since 2024-07-01
 */
@Getter
@Setter
public class ConditioningProgramItem implements Serializable {

    //明细类型（medicine 中医 acupoint穴位 img图片 video视频）
    private String type;

    //明细名称（中药、穴位）
    private String itemName;

    //描述
    private String description;

    //缩略图
    private String imgUrl;

    //媒体文件
    private String mediaUrl;

    //剂量
    private String dose;

    //单位
    private String unit;

    //备注
    private String remarks;

}
