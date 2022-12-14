package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.RoomConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomConfigurationRepository {
    List<RoomConfiguration> findAllByAreaAndBedroomCountAndPrice(Double area, Integer bedroomCount, Integer price);
    List<RoomConfiguration> getRoomConfigurations();
    Optional<RoomConfiguration> findById(Long id);
}
