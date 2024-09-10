package com.example.backend.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//registers first time connection
//creates an endpoint where the socket can be found 
@Configuration //this class contains methods that define how to create beans, and if you mark @Bean above a method , it will show how to create the bean object of that particular return type class.
@EnableWebSocket //configure the necessary components to handle WebSocket connections.
public class WebSocketConfig implements WebSocketConfigurer{

    //A single WebSocket endpoint in your server can handle multiple sessions, each representing a different client connection. 
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(new SocketConnectionHandler(), "/wsOrbito");  // This sets the WebSocket endpoint at /ws
    }
}
