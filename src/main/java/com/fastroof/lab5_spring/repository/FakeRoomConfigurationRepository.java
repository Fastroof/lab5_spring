package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.RoomConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeRoomConfigurationRepository implements RoomConfigurationRepository {
    private final List<RoomConfiguration> roomConfigurations = new ArrayList<>();

    public FakeRoomConfigurationRepository() {
        roomConfigurations.add(new RoomConfiguration(0L, 80.0, 2, 580));
        roomConfigurations.add(new RoomConfiguration(1L, 50.0, 1, 450));
        roomConfigurations.add(new RoomConfiguration(2L, 60.0, 1, 450));
        roomConfigurations.add(new RoomConfiguration(3L, 70.0, 2, 850));
        roomConfigurations.add(new RoomConfiguration(4L, 65.0, 1, 650));
        roomConfigurations.add(new RoomConfiguration(5L, 40.0, 1, 250));
    }

    public List<RoomConfiguration> findAllByAreaAndBedroomCountAndPrice(Double area, Integer bedroomCount, Integer price) {
        return roomConfigurations.stream().filter(roomConfiguration -> ((area == null) || (roomConfiguration.getArea().equals(area))) &&
                ((bedroomCount == null) || (roomConfiguration.getBedroomCount().equals(bedroomCount))) &&
                ((price == null) || (roomConfiguration.getPrice().equals(price)))
        ).toList();
    }


}
