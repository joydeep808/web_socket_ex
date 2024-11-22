package com.websockets.websockets.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.websockets.websockets.model.ChatMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }



    @MessageMapping("/chat.sendPrivateMessage")
    public ChatMessage sendPrivateMessage(@Payload ChatMessage chatMessage) {
        // template.convertAndSendToUser(chatMessage.getReceiver() , "/topic/public/"+chatMessage.getReceiver(), chatMessage);
        template.convertAndSendToUser(chatMessage.getReceiver() , "/queue/messages", chatMessage);

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}