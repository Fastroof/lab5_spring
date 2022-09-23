package com.fastroof.lab5_spring.repository.rowmapper;

import com.fastroof.lab5_spring.entity.RoomConfiguration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomConfigurationMapper implements RowMapper<RoomConfiguration> {
    @Override
    public RoomConfiguration mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RoomConfiguration(
                rs.getLong("id"),
                rs.getDouble("area"),
                rs.getInt("bedroom_count"),
                rs.getInt("price")
        );
    }
}
