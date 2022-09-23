package com.fastroof.lab5_spring.service;

import com.fastroof.lab5_spring.entity.Room;
import com.fastroof.lab5_spring.pojo.RoomCreationRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface RoomService {
    boolean addRoom(RoomCreationRequest roomCreationRequest, Principal principal);
    Room getRoom(Long id);
    boolean updateRoom(Long id, Room updatedRoom);
    boolean deleteRoom(Room room);
}
