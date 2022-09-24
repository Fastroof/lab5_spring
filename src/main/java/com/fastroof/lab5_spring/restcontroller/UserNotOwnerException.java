package com.fastroof.lab5_spring.restcontroller;

public class UserNotOwnerException extends RuntimeException {
    UserNotOwnerException(Long id) {
        super("You are not the owner of room with id = " + id);
    }
}
