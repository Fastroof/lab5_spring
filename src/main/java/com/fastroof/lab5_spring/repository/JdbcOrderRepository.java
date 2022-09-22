package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class JdbcOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;
    private final JdbcUserRepository userRepository;
    private final JdbcRoomRepository roomRepository;


    @Autowired
    public JdbcOrderRepository(JdbcUserRepository userRepository, JdbcRoomRepository roomRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Order> getOrders() {
        return jdbcTemplate.query(
                "select * from orders",
                (rs, rowNum) ->
                        new Order(
                                rs.getLong("id"),
                                userRepository.findById(rs.getLong("user_id")),
                                roomRepository.findById(rs.getLong("room_id")),
                                rs.getDate("date_start_contract"),
                                rs.getDate("date_end_contract"),
                                rs.getDouble("price")

                        )
        );
    }
}
