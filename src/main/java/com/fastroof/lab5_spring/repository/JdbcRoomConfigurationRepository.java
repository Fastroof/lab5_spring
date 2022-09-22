package com.fastroof.lab5_spring.repository;


import com.fastroof.lab5_spring.entity.RoomConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class JdbcRoomConfigurationRepository implements RoomConfigurationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRoomConfigurationRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RoomConfiguration> findAllByAreaAndBedroomCountAndPrice(Double area, Integer bedroomCount, Integer price) {
        return jdbcTemplate.query(
                "select * from room_configurations where area = ? and  bedroom_count = ? and price = ?",
                (rs, rowNum) ->
                        new RoomConfiguration(
                                rs.getLong("id"),
                                rs.getDouble("area"),
                                rs.getInt("bedroom_count"),
                                rs.getInt("price")
                        ),
                area,
                bedroomCount,
                price
        );
    }

    @Override
    public List<RoomConfiguration> getRoomConfigurations() {
        return jdbcTemplate.query(
                "select * from room_configurations",
                (rs, rowNum) ->
                        new RoomConfiguration(
                                rs.getLong("id"),
                                rs.getDouble("area"),
                                rs.getInt("bedroom_count"),
                                rs.getInt("price")
                        )
        );
    }

    public RoomConfiguration findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from room_configurations where id = ?",
                (rs, rowNum) ->
                        new RoomConfiguration(
                                rs.getLong("id"),
                                rs.getDouble("area"),
                                rs.getInt("bedroom_count"),
                                rs.getInt("price")
                        ),
                id
        );
    }
}

