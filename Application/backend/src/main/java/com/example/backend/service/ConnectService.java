package com.example.backend.service;

import java.util.Map;

import com.example.backend.constants.IdConstants;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class ConnectService {
    
    public void connectWithOpponent(JSONObject jsonObject, WebSocketSession session, Map<String, WebSocketSession> onlinePlayers){
        String playerId = jsonObject.getString(IdConstants.PLAYER_ID);
        String opponentId = jsonObject.getString(IdConstants.OPPONENT_ID);
        boolean isOpponentOnline = isOnline(opponentId, onlinePlayers);
        if(isOpponentOnline){
            //connect
        }
        //send something
    }

    private boolean isOnline(String playerId, Map<String,WebSocketSession> onlinePlayers){
        return onlinePlayers.containsKey(playerId);
    }
}
