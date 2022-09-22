package com.fastroof.lab5_spring.service;

import com.fastroof.lab5_spring.entity.Order;
import com.fastroof.lab5_spring.entity.Room;
import com.fastroof.lab5_spring.repository.OrderRepository;
import com.fastroof.lab5_spring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private OrderRepository fakeOrderRepository;

    public List<Room> getAllRooms() {
        return roomRepository.getRooms();
    }

    public List<Order> getAllOrders() {
        return fakeOrderRepository.getOrders();
    }
}
