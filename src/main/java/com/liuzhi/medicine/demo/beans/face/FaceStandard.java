package com.liuzhi.medicine.demo.beans.face;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author guowei
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaceStandard implements Serializable {

    @ApiModelProperty("标准值")
    private String standardValue;

    @ApiModelProperty("实际值")
    private List<FaceActual> actualList;

}
