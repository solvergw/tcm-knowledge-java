package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author guowei
 * @since 2022/11/12
 */
@Data
@NoArgsConstructor
public class ConstitutionResultItem implements Serializable {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("体质")
    private String name;
    @ApiModelProperty("得分")
    private int score;
    @ApiModelProperty("分类 1主体质 2兼体质 3倾向体质")
    private int type;

}
