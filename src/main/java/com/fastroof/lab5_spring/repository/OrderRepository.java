package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    List<Order> getOrders();
}
