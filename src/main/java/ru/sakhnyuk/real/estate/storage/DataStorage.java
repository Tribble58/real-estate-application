package ru.sakhnyuk.real.estate.storage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.sakhnyuk.real.estate.storage.model.House;

import java.util.List;

@Repository
public class DataStorage {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger log = LoggerFactory.getLogger(DataStorage.class);

    public List<House> getHouses() {
        return jdbcTemplate.query("select * from real_estate.houses;", new BeanPropertyRowMapper<>(House.class));
    }
}
