package com.pingme.chat.backend.services;

import com.pingme.chat.backend.entities.Room;
import com.pingme.chat.backend.repositories.RoomRepository;
import com.pingme.chat.backend.interfaces.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    // Implement the methods defined in RoomService interface
    // For example, you might have methods like createRoom, getRoomById, etc.


    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }



    @Override
    public Room createRoom(String roomId) {
        // Logic to create a room
        if (roomRepository.findByRoomId(roomId) != null) {
            return null; // Room already exists
        }

        // Create a new Room object
        Room newRoom = new Room();
        newRoom.setRoomId(roomId);

        // Save the room to the repository
        roomRepository.save(newRoom);
        return newRoom; // Room created successfully
    }



    @Override
    public boolean deleteRoom(String roomId) {
        return false;
    }

    @Override
    public Room findByRoomId(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if(room == null){
            return null;
        }
        return room;
    }

    @Override
    public String getRoomDetails(String roomId) {
        return null;
    }

    // Add more methods as needed for your application
}
