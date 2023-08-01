package ru.sakhnyuk.real.estate.storage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.sakhnyuk.real.estate.storage.model.House;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataStorage {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger log = LoggerFactory.getLogger(DataStorage.class);

    public List<House> getHouses() {
        return jdbcTemplate.query("select * from real_estate.houses;", new HouseRowMapper());
    }

    private class HouseRowMapper implements RowMapper<House>{

        @Override
        public House mapRow(ResultSet rs, int rowNum) throws SQLException {
            House house = new House();
            house.setId(rs.getInt("id"));
            house.setAddress(rs.getString("address"));
            house.setCity(rs.getString("city"));
            house.setState(rs.getString("state"));
            house.setCountry(rs.getString("country"));
            return house;
        }
    }
}
