package com.example.backend.service;

import java.util.Map;

import com.example.backend.constants.IdConstants;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;


@Service
public class RegisterService {

    public void registerPlayer(JSONObject jsonObject, WebSocketSession session, Map<String, WebSocketSession> onlinePlayers){
        String playerId = jsonObject.getString(IdConstants.PLAYER_ID);
        onlinePlayers.put(playerId, session);
    } 
    
}
