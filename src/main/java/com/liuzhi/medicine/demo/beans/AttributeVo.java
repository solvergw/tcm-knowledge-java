package com.liuzhi.medicine.demo.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author guowei
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeVo {

    @ApiModelProperty("字段")
    private String field;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private Object content;
}
