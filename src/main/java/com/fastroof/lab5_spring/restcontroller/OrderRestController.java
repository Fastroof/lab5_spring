package com.fastroof.lab5_spring.restcontroller;

import com.fastroof.lab5_spring.entity.Order;
import com.fastroof.lab5_spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    private final OrderRepository fakeOrderRepository;

    @Autowired
    public OrderRestController(OrderRepository fakeOrderRepository) {
        this.fakeOrderRepository = fakeOrderRepository;
    }

    @GetMapping("/orders")
    List<Order> allOrders() {
        return fakeOrderRepository.getOrders();
    }

}
