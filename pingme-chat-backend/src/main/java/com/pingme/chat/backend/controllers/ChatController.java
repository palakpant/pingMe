package com.pingme.chat.backend.controllers;


import com.pingme.chat.backend.entities.Message;
import com.pingme.chat.backend.entities.Room;
import com.pingme.chat.backend.interfaces.RoomService;
import com.pingme.chat.backend.payload.MessageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    private RoomService roomService;
    public ChatController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Additional methods for handling chat-related requests can be added here
    // For example, methods to send messages, get rooms, etc.

    @MessageMapping("/sendMessage/{roomId") //client to server
    @SendTo("/topic/room/{roomId}") //server to client 
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request) throws Exception {
       Room room = roomService.findByRoomId(request.getRoomId());
       Message message = new Message();
       message.setContent(request.getContent());
       message.setSender(request.getSender());
       message.setTimestamp(LocalDateTime.now());
       if(room!=null) {
           room.getMessageList().add(message);
           roomService.createRoom(room.getRoomId());
       }else{
           throw new RuntimeException("Room not found");
       }
         return message;
    }
}
