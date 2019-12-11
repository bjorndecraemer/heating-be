package com.bjornspetprojects.heatingbe.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class HeatingStompController {


    private final StompMessageHandler stompMessageHandler;

    public HeatingStompController(StompMessageHandler stompMessageHandler) {
        this.stompMessageHandler = stompMessageHandler;
    }

    @MessageMapping("/send")
    @SendTo("/topic/festates")
    public String feStateChanged(FeState feState){
        stompMessageHandler.handleFeStateMessage(feState);
        return "OK";
    }
}
