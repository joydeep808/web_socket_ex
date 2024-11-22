package com.websockets.websockets.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebsocketEventListner {
  private final SimpMessageSendingOperations messagingTemplate;

  // @EventListener
  // public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
  //       StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
  //       String username = (String) headerAccessor.getSessionAttributes().get("username");
  //       if (username != null) {
  //           var chatMessage = Message.builder()
  //                   .type(MessageType.LEAVE)
  //                   .sender(username)
  //                   .build();
  //           messagingTemplate.convertAndSend("/topic/public", chatMessage);
  //       }
  //   }
}
