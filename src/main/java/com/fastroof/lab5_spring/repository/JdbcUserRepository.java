package com.fastroof.lab5_spring.repository;


import com.fastroof.lab5_spring.entity.User;
import com.fastroof.lab5_spring.enums.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(
                "select * from users",
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("full_name"),
                                Provider.valueOf(rs.getString("provider"))
                        )
        );
    }

    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(
                "select * from users where email = ?",
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("full_name"),
                                Provider.valueOf(rs.getString("provider"))
                        ),
                email
        );
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from users where id = ?",
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("full_name"),
                                Provider.valueOf(rs.getString("provider"))
                        ),
                id
        );
    }
}
