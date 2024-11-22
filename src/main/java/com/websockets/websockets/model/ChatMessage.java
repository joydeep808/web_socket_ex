package com.websockets.websockets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
  private String content;
  private String sender;
  private String receiver;
  private MessageType type;

  public enum MessageType {
      CHAT, JOIN, LEAVE
  }
}