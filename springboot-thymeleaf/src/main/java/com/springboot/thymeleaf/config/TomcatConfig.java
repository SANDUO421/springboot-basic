package com.springboot.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.MultipartConfigElement;

/**
 * linux  文件上传 临时存储 bug
 * @author 三多
 * @Time 2020/4/11
 */
@Configuration
public class TomcatConfig {
    @Autowired
    private Environment environment;

    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(environment.getProperty("server.tomcat.basedir"));
        return factory.createMultipartConfig();
    }
}
