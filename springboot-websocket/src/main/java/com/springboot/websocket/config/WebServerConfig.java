package com.springboot.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启对WebSocket的支持
 * @author 三多
 * @Time 2020/4/13
 */
@Configuration
public class WebServerConfig {
    /**
     * WEBSOCKET 配置器
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
