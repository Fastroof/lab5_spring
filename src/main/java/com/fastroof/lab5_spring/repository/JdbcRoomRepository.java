package com.fastroof.lab5_spring.repository;

import com.fastroof.lab5_spring.entity.Room;
import com.fastroof.lab5_spring.entity.RoomConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
public class JdbcRoomRepository implements RoomRepository {
    private final JdbcTemplate jdbcTemplate;
    private final JdbcRoomConfigurationRepository roomConfigurationRepository;
    private final JdbcRoomDescriptionRepository roomDescriptionRepository;
    private final JdbcUserRepository userRepository;

    public JdbcRoomRepository(JdbcRoomConfigurationRepository roomConfigurationRepository,
                              JdbcRoomDescriptionRepository roomDescriptionRepository,
                              JdbcUserRepository userRepository,
                              DataSource dataSource) {
        this.roomConfigurationRepository = roomConfigurationRepository;
        this.roomDescriptionRepository = roomDescriptionRepository;
        this.userRepository = userRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Room findByRoomConfiguration(RoomConfiguration roomConfiguration) {
        return jdbcTemplate.queryForObject(
                "select * from rooms where configuration_id = ?",
                (rs, rowNum) ->
                        new Room(
                                rs.getLong("id"),
                                roomConfigurationRepository.findById(rs.getLong("configuration_id")),
                                roomDescriptionRepository.findById(rs.getLong("description_id")),
                                userRepository.findById(rs.getLong("user_id"))
                        ),
                roomConfiguration.getId()
        );
    }

    @Override
    public Room findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from rooms where id = ?",
                (rs, rowNum) ->
                        new Room(
                                rs.getLong("id"),
                                roomConfigurationRepository.findById(rs.getLong("configuration_id")),
                                roomDescriptionRepository.findById(rs.getLong("description_id")),
                                userRepository.findById(rs.getLong("user_id"))
                        ),
                id
        );
    }

    @Override
    public List<Room> getRooms() {
        return jdbcTemplate.query(
                "select * from rooms",
                (rs, rowNum) ->
                        new Room(
                                rs.getLong("id"),
                                roomConfigurationRepository.findById(rs.getLong("configuration_id")),
                                roomDescriptionRepository.findById(rs.getLong("description_id")),
                                userRepository.findById(rs.getLong("user_id"))
                        )
        );
    }
}
