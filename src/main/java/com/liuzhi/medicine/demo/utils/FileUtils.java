package com.liuzhi.medicine.demo.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * @author guowei
 */
public class FileUtils {
    public static String fileToBase64(String filePath) throws IOException {
        File file = ResourceUtils.getFile("classpath:" + filePath);
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}
