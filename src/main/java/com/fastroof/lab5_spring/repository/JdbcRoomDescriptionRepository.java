package com.fastroof.lab5_spring.repository;


import com.fastroof.lab5_spring.entity.RoomDescription;
import org.jetbrains.annotations.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class JdbcRoomDescriptionRepository implements RoomDescriptionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRoomDescriptionRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RoomDescription> getRoomDescriptions() {
        return jdbcTemplate.query(
                "select * from room_descriptions",
                (rs, rowNum) ->
                        new RoomDescription(
                                rs.getLong("id"),
                                rs.getString("description"),
                                rs.getString("address"),
                                rs.getDate("creation_date")
                        )
        );
    }

    public RoomDescription findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from room_descriptions where id = ?",
                (rs, rowNum) ->
                        new RoomDescription(
                                rs.getLong("id"),
                                rs.getString("description"),
                                rs.getString("address"),
                                rs.getDate("creation_date")
                        ),
                id
        );
    }
}
