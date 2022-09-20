package com.fastroof.lab5_spring.repository;


import com.fastroof.lab5_spring.entity.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeOrderRepository implements OrderRepository{
    private RoomRepository fakeRoomRepository;
    private UserRepository fakeUserRepository;

    private final List<Order> orders = new ArrayList<>();

    @Autowired
    public FakeOrderRepository(RoomRepository fakeRoomRepository, UserRepository fakeUserRepository){
        this.fakeRoomRepository = fakeRoomRepository;
        this.fakeUserRepository = fakeUserRepository;
        orders.add(new Order(1L, fakeUserRepository.getUsers().get(0), fakeRoomRepository.getRooms().get(0), new Date(), new Date(), 444.6) );
        orders.add(new Order(2L, fakeUserRepository.getUsers().get(1), fakeRoomRepository.getRooms().get(1), new Date(), new Date(), 154.6) );
    }
}
