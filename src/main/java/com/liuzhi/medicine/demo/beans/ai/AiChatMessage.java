package com.liuzhi.medicine.demo.beans.ai;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guowei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiChatMessage {

    @ApiModelProperty("会话ID")
    private String sessionId;
    @ApiModelProperty("健康档案")
    private String healthDoc;
    @ApiModelProperty("用户消息")
    private String message;
    @ApiModelProperty("图片地址")
    private String imageUrl;

}
