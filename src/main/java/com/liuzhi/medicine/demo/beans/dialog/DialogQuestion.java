package com.liuzhi.medicine.demo.beans.dialog;

import com.liuzhi.medicine.demo.beans.face.FaceStandard;
import com.liuzhi.medicine.demo.beans.tongue.TongueStandard;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guowei
 */
@Data
public class DialogQuestion implements Serializable {

    //类型（tongue舌象 tongue_result舌象结果 disease疾病 disease_result疾病结果 symptom症状 report分析报告）
    private String classify;

    //标题
    private String title;

    //样式(select 单选 checkbox 多选 tongue 舌象 hide 隐藏)
    private String css;

    //是否必填（1是0否）
    private boolean required;

    //会话结束标志
    private boolean over;

    //内容
    private String content;
    //舌象
    private String tongue;
    //面象
    private String face;

    /**** classify != report 时，返回问题 ****/
    //选项
    private List<DialogOption> options;

    /**** classify = tongue_result 时，返回分割后的舌象图片 ****/
    //舌面图片
    private String tongueImgUrl;
    //舌底图片
    private String tongueBackImgUrl;
    //面部图片
    private String faceImgUrl;
    //左侧面部图片
    private String faceLeftImgUrl;
    //右侧面部图片
    private String faceRightImgUrl;

    /**
     * 上传图片支持流文件
     */
    @ApiModelProperty("舌面图片base64")
    private String tongueImgFile;
    @ApiModelProperty("舌底图片base64")
    private String tongueBackImgFile;
    @ApiModelProperty("面部图片base64")
    private String faceImgFile;
    @ApiModelProperty("左侧面部图片base64")
    private String faceLeftImgFile;
    @ApiModelProperty("右侧面部图片base64")
    private String faceRightImgFile;

    /**** classify = tongue_result 时，返回舌象结果 ****/
    //舌色
    private TongueStandard tongueColor;
    //苔色
    private TongueStandard tongueCoatingColor;
    //苔质
    private TongueStandard tongueCoating;
    //舌形
    private TongueStandard tongueShape;
    //津液
    private TongueStandard bodyFluid;
    //舌下络脉
    private TongueStandard sublingualVein;

    /**** classify = tongue_result 时，返回面象结果 ****/
    //面象
    @ApiModelProperty("面色")
    private FaceStandard faceColor;

    @ApiModelProperty("主色")
    private FaceStandard mainColor;

    @ApiModelProperty("光泽")
    private FaceStandard shine;

    @ApiModelProperty("黑眼圈")
    private FaceStandard blackEye;

    @ApiModelProperty("唇色")
    private FaceStandard lipColor;

    @ApiModelProperty("眼神")
    private FaceStandard eyeContact;

    @ApiModelProperty("目色")
    private FaceStandard eyeColor;

    @ApiModelProperty("两颧红")
    private FaceStandard hecticCheek;

    @ApiModelProperty("鼻褶")
    private FaceStandard noseFold;

    @ApiModelProperty("眉间/鼻柱青色")
    private FaceStandard cyanGlabella;

    @ApiModelProperty("面部皮损")
    private FaceStandard faceSkinDefects;
}
