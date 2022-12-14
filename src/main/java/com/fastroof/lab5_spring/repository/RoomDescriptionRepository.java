package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.RoomDescription;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomDescriptionRepository {
    List<RoomDescription> getRoomDescriptions();
    Optional<RoomDescription> findById(Long id);
}
