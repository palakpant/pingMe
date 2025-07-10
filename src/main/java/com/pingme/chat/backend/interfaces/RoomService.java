package com.pingme.chat.backend.interfaces;

import com.pingme.chat.backend.entities.Room;

public interface RoomService {

    /**
     * Creates a new room with the given room ID.
     *
     * @param roomId the ID of the room to be created
     * @return true if the room was created successfully, false otherwise
     */
    Room createRoom(String roomId);

    /**
     * Deletes the room with the given room ID.
     *
     * @param roomId the ID of the room to be deleted
     * @return true if the room was deleted successfully, false otherwise
     */
    boolean deleteRoom(String roomId);

    Room findByRoomId(String roomId);

    /**
     * Retrieves the details of a room by its ID.
     *
     * @param roomId the ID of the room to retrieve
     * @return a string containing the details of the room, or null if not found
     */
    String getRoomDetails(String roomId);
}
