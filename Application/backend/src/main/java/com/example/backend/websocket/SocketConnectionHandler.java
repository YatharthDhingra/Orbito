package com.example.backend.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.backend.constants.ActionTypeConstants;

//This is for handling websocket messages, handles the connection and exchange of messages
public class SocketConnectionHandler extends TextWebSocketHandler{
    //thread safe map <userId , session>
    //session refers to period of interaction (stateful)
    private final Map<String, WebSocketSession> onlinePlayers = new ConcurrentHashMap<>();

    //we don't need a afterConnectionEstablished function.

    //CloseStatus-encapsulates the status code and the reason for the WebSocket connection closure.
    @Override 
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        super.afterConnectionClosed(session, status);
        /*remove this, or log it out*/
        System.out.println(session.getId() + " Closed");
        onlinePlayers.values().remove(session);
    }

    //takes incoming message from that socket
    @Override
    public void handleTextMessage(WebSocketSession session, 
                              TextMessage message) 
        throws Exception 
    { 
        String payload = message.getPayload(); //gets it as string
        JSONObject jsonObject = new JSONObject(payload); // Parse the JSON content

        String actionType = jsonObject.getString("actionType");

        switch(actionType){
            case ActionTypeConstants.REGISTER:
                //do this
                break;
            case ActionTypeConstants.CONNECT:
                //do this
                break;
            case ActionTypeConstants.MOVE:
                //do this
                break;
        }
    } 
}

