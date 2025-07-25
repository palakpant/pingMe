package com.pingme.chat.backend.controllers;


import com.pingme.chat.backend.entities.Message;
import com.pingme.chat.backend.entities.Room;
import com.pingme.chat.backend.interfaces.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomService roomService;

    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //create room

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        // Logic to create a room
        Room roomCreated = roomService.createRoom(roomId);
        return roomCreated != null ? ResponseEntity.status(HttpStatus.CREATED).body(roomCreated) : ResponseEntity.badRequest().body("Room already exists"); // Placeholder return
    }

    //get room by id

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        Room room = roomService.findByRoomId(roomId);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }

    }


    //get messages of room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId ,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "20", required = false) int size
        ) {
        Room room = roomService.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        //get messages
        //pagination
        List<Message> messages = room.getMessageList();
        int start = Math.max(0, messages.size() - (page + 1) * size);
         int end = Math.min((page + 1) * size, messages.size());
        return ResponseEntity.ok(messages.subList(start, end)
        );
    }
}
