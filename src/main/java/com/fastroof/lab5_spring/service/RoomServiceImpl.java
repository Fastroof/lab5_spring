package com.fastroof.lab5_spring.service;

import com.fastroof.lab5_spring.entity.Room;
import com.fastroof.lab5_spring.repository.RoomConfigurationRepository;
import com.fastroof.lab5_spring.repository.RoomDescriptionRepository;
import com.fastroof.lab5_spring.repository.RoomRepository;
import com.fastroof.lab5_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomConfigurationRepository roomConfigurationRepository;
    @Autowired
    private RoomDescriptionRepository roomDescriptionRepository;

    @Override
    public boolean addRoom(Room room) {
        roomDescriptionRepository.getRoomDescriptions().add(room.getDescription());
        roomConfigurationRepository.getRoomConfigurations().add(room.getConfiguration());
        room.setUser(userRepository.getUsers().get(0));
        Long id = roomRepository.getRooms().get(roomRepository.getRooms().size() - 1).getId() + 1;
        room.setId(id);
        room.getConfiguration().setId(id);
        room.getDescription().setId(id);
        room.getDescription().setCreationDate(new Date());
        return roomRepository.getRooms().add(room);
    }

    @Override
    public Room getRoom(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room updateRoom(Room oldRoom, Room updatedRoom) {
        int index = roomRepository.getRooms().indexOf(oldRoom);
        roomConfigurationRepository.getRoomConfigurations().set(index, updatedRoom.getConfiguration());
        roomDescriptionRepository.getRoomDescriptions().set(index, updatedRoom.getDescription());
        updatedRoom.setUser(oldRoom.getUser());
        updatedRoom.getDescription().setCreationDate(oldRoom.getDescription().getCreationDate());
        updatedRoom.getDescription().setId(updatedRoom.getId());
        updatedRoom.getConfiguration().setId(updatedRoom.getId());
        return roomRepository.getRooms().set(index, updatedRoom);
    }

    @Override
    public boolean deleteRoom(Room room){
        roomConfigurationRepository.getRoomConfigurations().remove(room.getConfiguration());
        roomDescriptionRepository.getRoomDescriptions().remove(room.getDescription());
        return roomRepository.getRooms().remove(room);
    }
}
