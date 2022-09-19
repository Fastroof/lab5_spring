package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<User> getUsers();

    User findByEmail(String email);
}