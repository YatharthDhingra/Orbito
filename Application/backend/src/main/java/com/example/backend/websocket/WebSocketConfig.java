package com.example.backend.websocket;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//registers first time connection
//creates an endpoint where the socket can be found 
public class WebSocketConfig implements WebSocketConfigurer{

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry){

    }
}
