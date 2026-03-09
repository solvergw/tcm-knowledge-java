package com.liuzhi.medicine.demo.beans.constitution;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guowei
 * @since 2022/11/12
 */
@Data
public class ConstitutionResult implements Serializable {

    @ApiModelProperty("所有体质")
    public List<ConstitutionResultItem> all = new ArrayList<>();
    @ApiModelProperty("主体质")
    public List<ConstitutionResultItem> mainList = new ArrayList<>();
    @ApiModelProperty("兼体质")
    public List<ConstitutionResultItem> subList = new ArrayList<>();
    @ApiModelProperty("倾向体质")
    public List<ConstitutionResultItem> inclinedList = new ArrayList<>();
    @ApiModelProperty("体质结果")
    public List<ConstitutionResultItem> resultList = new ArrayList<>();
    @ApiModelProperty("体质结果文字描述")
    public String result;


}
