package com.liuzhi.medicine.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author solve
 */
public class Base64Utils {
    /**
     * <p>
     * 二进制数据编码为BASE64字符串
     *
     * @param base64 base64
     * @return String
     */
    public static String encode(byte[] base64) {
        return new String(Base64.encodeBase64(base64), StandardCharsets.UTF_8);
    }

    /**
     * <p>
     * BASE64字符串解码为二进制数据
     * </p>
     *
     * @param base64 base64
     * @return String
     */
    public static byte[] decode(String base64) {
        return Base64.decodeBase64(base64.getBytes(StandardCharsets.UTF_8));
    }


}
