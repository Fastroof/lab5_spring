package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.Room;
import com.fastroof.lab5_spring.entity.RoomConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository {
    Room findByRoomConfiguration(RoomConfiguration roomConfiguration);
    Room findById(Long id);
    List<Room> getRooms();
}
