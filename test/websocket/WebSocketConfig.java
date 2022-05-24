package com.example.seu.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

@EnableWebSocket // [1]
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    WebSocketHandler defaultHandler;

    @Resource
    DefaultInterceptor defaultInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(defaultHandler,"ws").addInterceptors(defaultInterceptor).setAllowedOrigins("*");
    }
}