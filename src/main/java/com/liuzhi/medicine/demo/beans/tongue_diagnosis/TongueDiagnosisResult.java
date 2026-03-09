package com.liuzhi.medicine.demo.beans.tongue_diagnosis;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author guowei
 * @since 2025-03-10
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "TongueDiagnosisResult对象", description = "舌诊结果")
public class TongueDiagnosisResult implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String IMG_URL_PREFIX = "https://static.hzliuzhi.com:62006/tongue_diagnosis/";

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("业务ID")
    private String outId;

    @ApiModelProperty("舌色")
    private String tongueColor;

    @ApiModelProperty("苔色")
    private String mossColor;

    @ApiModelProperty("苔质")
    private String moss;

    @ApiModelProperty("舌形")
    private String tongueShape;

    @ApiModelProperty("津液")
    private String bodyfluid;

    @ApiModelProperty("舌下")
    private String vein;

    @ApiModelProperty("面色")
    private String faceColor;
    @ApiModelProperty("主色")
    private String mainColor;
    @ApiModelProperty("光泽")
    private String luster;
    @ApiModelProperty("黑眼圈")
    private String darkCircle;
    @ApiModelProperty("唇色")
    private String lipColor;
    @ApiModelProperty("眼神")
    private String brightEyes;
    @ApiModelProperty("目色")
    private String yeyColor;
    @ApiModelProperty("两颧红")
    private String redCheeks;
    @ApiModelProperty("鼻褶")
    private String nasalFold;
    @ApiModelProperty("眉间青色")
    private String glabellaCyan;
    @ApiModelProperty("面部皮损")
    private String faceSkinDefects;

    @ApiModelProperty("其他属性")
    private String attrList;

    @ApiModelProperty("结果")
    private String classifyResult;

    @ApiModelProperty("舌面原图")
    private String tongueTopOriginPath;

    @ApiModelProperty("舌面检测图")
    private String tongueTopDetectPath;

    @ApiModelProperty("舌面分割图")
    private String tongueTopSegmentPath;

    @ApiModelProperty("舌下原图")
    private String tongueUnderOriginPath;

    @ApiModelProperty("舌下检测图")
    private String tongueUnderDetectPath;

    @ApiModelProperty("舌下分割图")
    private String tongueUnderSegmentPath;

    @ApiModelProperty("面部原图")
    private String faceOriginPath;

    @ApiModelProperty("面部检测图")
    private String faceDetectPath;

    @ApiModelProperty("裂纹图")
    private String crackedPath;

    @ApiModelProperty("瘀斑图")
    private String ecchymosisPath;

    @ApiModelProperty("剥落图")
    private String erodedPath;

    @ApiModelProperty("瘀点图")
    private String petechiaePath;

    @ApiModelProperty("点刺图")
    private String spottedPath;

    @ApiModelProperty("齿痕图")
    private String teethPrintedPath;

    private String errorMsg;

    @ApiModelProperty("舌象特征")
    private String tongueStr;
    @ApiModelProperty("面象特征")
    private String faceStr;

    public static TongueDiagnosisResult fromResponse(Object data) {
        if (data == null) {
            TongueDiagnosisResult bean = new TongueDiagnosisResult();
            bean.setErrorMsg("图像检测失败，请重新拍摄上传");
            return bean;
        }

        TongueDiagnosisResult bean = JSONUtil.toBean(JSONUtil.toJsonStr(data), TongueDiagnosisResult.class);
        if (bean.getClassifyResult() == null) {
            bean.setErrorMsg("图像检测失败，请重新拍摄上传");
        }
        JSONObject classifyResult = JSONUtil.parseObj(bean.getClassifyResult());

        if (classifyResult.containsKey("舌面")) {
            bean.setErrorMsg(classifyResult.getStr("舌面"));
        }

        bean.setTongueColor(classifyResult.getStr("舌色"));
        bean.setMossColor(classifyResult.getStr("苔色"));
        bean.setMoss(classifyResult.getStr("苔质"));
        bean.setTongueShape(classifyResult.getStr("舌形"));
        bean.setBodyfluid(classifyResult.getStr("津液"));
        bean.setVein(classifyResult.getStr("舌下"));

        bean.setFaceColor(classifyResult.getStr("面色"));
        bean.setMainColor(classifyResult.getStr("主色"));
        bean.setLuster(classifyResult.getStr("光泽"));
        bean.setDarkCircle(classifyResult.getStr("黑眼圈"));
        bean.setLipColor(classifyResult.getStr("唇色"));
        bean.setBrightEyes(classifyResult.getStr("眼神"));
        bean.setYeyColor(classifyResult.getStr("目色"));
        bean.setRedCheeks(classifyResult.getStr("两颧红"));
        bean.setNasalFold(classifyResult.getStr("鼻褶"));
        bean.setGlabellaCyan(classifyResult.getStr("眉间青色"));
        bean.setFaceSkinDefects(classifyResult.getStr("面部皮损"));

        bean.setAttrList(JSONUtil.toJsonStr(classifyResult.get("attr_list")));

        return bean;

    }


    public String getTongueStr() {
        if (tongueStr == null) {
            tongueStr = compactTongueStr();
        }
        return tongueStr;
    }

    public String getFaceStr() {
        if (faceStr == null) {
            faceStr = compactFaceStr();
        }
        return faceStr;
    }


    /**
     * 舌象特征汇总
     */
    public String compactTongueStr() {

        List<String> tongueList = ListUtil.toList(
                getErrorMsg(),
                getTongueColor(),
                getMossColor(),
                getTongueShape(),
                getMoss(),
                getBodyfluid(),
                getVein());

        return tongueList.stream().filter(Objects::nonNull)
                .flatMap(name -> Arrays.stream(name.split(",")))
                .filter(name -> !"异常舌形".equals(name))
                .collect(Collectors.joining("，"));
    }

    private static final List<String> FACE_NORMAL = Arrays.asList("正常", "左眼正常", "右眼正常");
    private static final List<String> FACE_EXCEPT = Arrays.asList("不符合要求（装扮或眼部受伤）", "不符合检测要求", "需进一步检测", "");

    /**
     * 面象特征汇总
     */
    public String compactFaceStr() {
        List<String> faceList = new ArrayList<>();

        if (StringUtils.isNotBlank(getFaceColor())) {
            faceList.add(getFaceColor());
        }
        if (getMainColor() != null && !FACE_NORMAL.contains(getMainColor()) && !"正常色".equals(getMainColor())) {
            faceList.add(getMainColor());
        }
        if (getLuster() != null && !FACE_NORMAL.contains(getLuster())) {
            faceList.add(getLuster() + "光泽");
        }
        if (getDarkCircle() != null && !FACE_NORMAL.contains(getDarkCircle()) && !FACE_EXCEPT.contains(getDarkCircle())) {
            faceList.add(getDarkCircle() + "黑眼圈");
        }
        if (getLipColor() != null && !FACE_NORMAL.contains(getLipColor()) && !FACE_EXCEPT.contains(getLipColor())) {
            faceList.add("唇色" + getLipColor());
        }
        if (getBrightEyes() != null && !"不符合检测要求".equals(getBrightEyes())) {
            faceList.add("眼神" + getBrightEyes());
        }
        if (getYeyColor() != null && !FACE_NORMAL.contains(getYeyColor()) && !FACE_EXCEPT.contains(getYeyColor())) {
            faceList.add(getYeyColor());
        }
        if (getRedCheeks() != null && !FACE_NORMAL.contains(getRedCheeks()) && !"无".equals(getRedCheeks())) {
            faceList.add(getRedCheeks() + "两颧红");
        }
        if (getNasalFold() != null && !"无".equals(getNasalFold())) {
            faceList.add(getNasalFold() + "鼻褶");
        }
        if (getGlabellaCyan() != null && !FACE_NORMAL.contains(getGlabellaCyan()) && !"无".equals(getGlabellaCyan())) {
            faceList.add(getGlabellaCyan());
        }
        if (getFaceSkinDefects() != null && !FACE_NORMAL.contains(getFaceSkinDefects())) {
            faceList.add(getFaceSkinDefects());
        }
        return String.join("，", faceList);
    }

    /**
     * 舌头正面图片
     */
    public String getTongueImg() {
        if (getTongueTopSegmentPath() == null) {
            return "";
        }
        return IMG_URL_PREFIX + getTongueTopSegmentPath();
    }

    /**
     * 舌头下面图片
     */
    public String getTongueBackImg() {
        if (getTongueUnderSegmentPath() == null) {
            return "";
        }
        return IMG_URL_PREFIX + getTongueUnderSegmentPath();
    }

    /**
     * 面部正面图片
     */
    public String getFaceImg() {
        if (getFaceDetectPath() == null) {
            return "";
        }
        return IMG_URL_PREFIX + getFaceDetectPath();
    }

    public Map<String, String> getAttrMap() {
        if (StrUtil.isBlank(attrList)) {
            return new HashMap<>();
        }
        // 'attr_list': {'舌色': '淡红舌', '苔面积': '正常', '津液': '润', '舌形老嫩': '正常', '舌形胖瘦': '正常', '裂纹程度': '正常', '苔色': '白苔', '苔厚程度': '苔轻度厚', '腻苔': '轻度腻', '苔质腐': '正常', '苔质剥落': '正常'}

        Map<String, String> result = new HashMap<>();
        JSONObject jsonObject = JSONUtil.parseObj(attrList);
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            result.put(entry.getKey(), entry.getValue().toString());
        }

        return result;
    }
}
