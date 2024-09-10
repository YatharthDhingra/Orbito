package com.example.backend.websocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//This is for handling websocket messages, handles the connection and exchange of messages
public class SocketConnectionHandler extends TextWebSocketHandler{
    //this list stores all connections, thread safe
    //session refers to period of interaction (stateful)
    // contains methods for sending messages, closing the session, and retrieving session-related information.
    List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        super.afterConnectionEstablished(session);
        /*remove this, or log it out*/
        System.out.println(session.getId() + " Connected");
        webSocketSessions.add(session);
    }

    //CloseStatus-encapsulates the status code and the reason for the WebSocket connection closure.
    @Override 
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        super.afterConnectionClosed(session, status);
        /*remove this, or log it out*/
        System.out.println(session.getId() + " Closed");
        webSocketSessions.remove(session);
    }

    //takes incoming message from that socket and forwards it to other sockets(users)
    @Override
    public void handleMessage(WebSocketSession session, 
                              WebSocketMessage<?> message) 
        throws Exception 
    { 
  
        super.handleMessage(session, message); 
  
        // Iterate through the list and pass the message to 
        // all the sessions Ignore the session in the list 
        // which wants to send the message. 
        for (WebSocketSession webSocketSession : 
             webSocketSessions) { 
            if (session == webSocketSession) 
                continue; 
  
            // sendMessage is used to send the message to 
            // the session 
            webSocketSession.sendMessage(message); 
        } 
        System.out.println(message);
    } 
}

