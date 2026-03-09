package com.liuzhi.medicine.demo.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guowei
 */
public class ParamsUtils {

    public static String linkParam(Object params) {

        String str = JSONUtil.toJsonStr(params);
        String result;

        if (params instanceof String) {
            result = str;
        } else if (params instanceof Number) {
            result = String.valueOf(params);
        } else if (params instanceof Boolean) {
            result = String.valueOf(params);
        } else if (params instanceof Date) {
            result = DatePattern.NORM_DATETIME_FORMAT.format(params);
        } else if (JSONUtil.isTypeJSONArray(str)) {

            JSONArray arr = JSONUtil.parseArray(str);
            result = "[" + arr.stream().map(ParamsUtils::linkParam).collect(Collectors.joining(",")) + "]";

        } else if (JSONUtil.isTypeJSON(str)) {

            JSONObject obj = JSONUtil.parseObj(str);
            result = obj.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(entry -> entry.getKey() + "=" + linkParam(entry.getValue()))
                    .collect(Collectors.joining("&"));

        } else {
            result = str;
        }

        return result;
    }

    public static String linkParam(Map<String, String[]> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String[] value = params.get(key);

            sb.append(key);
            sb.append("=");
            sb.append(value[0]);

            // 拼接时，不包括最后一个&字符
            if (i < keys.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

}
