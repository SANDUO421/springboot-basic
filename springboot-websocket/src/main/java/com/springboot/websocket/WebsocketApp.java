package com.springboot.websocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 三多
 * @Time 2020/4/13
 */
@SpringBootApplication
//@MapperScan("com.springboot.websocket.mapper")
public class WebsocketApp {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApp.class,args);
    }
}
