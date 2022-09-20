package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.User;
import com.fastroof.lab5_spring.enums.Provider;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();
    public FakeUserRepository() {
        users.add(new User(1L, "john@gmail.com", "$2a$08$UnToTL1tsdZijK.nKaGeFO6nNtHlznJWBf.izk48yAeuBQagogj3i", "John Bill", Provider.LOCAL));
        users.add(new User(2L, "bob@gmail.com", "$2a$08$F8cSKAN16de8rbe5V6zbUOBmGQXGd3Im3fAAUOk4fqEMp4B6EeyPi", "Bob Brown", Provider.LOCAL));
    }

    @Override
    public User findByEmail(String email) {
        return users.stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
    }
}
