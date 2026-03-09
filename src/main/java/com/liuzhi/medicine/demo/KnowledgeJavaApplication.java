package com.liuzhi.medicine.demo;

import com.liuzhi.medicine.demo.properties.KnowledgeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author guowei
 */
@SpringBootApplication
@EnableConfigurationProperties({KnowledgeProperties.class})
public class KnowledgeJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KnowledgeJavaApplication.class, args);
    }

}
