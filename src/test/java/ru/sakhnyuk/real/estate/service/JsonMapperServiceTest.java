package ru.sakhnyuk.real.estate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.sakhnyuk.real.estate.storage.DataStorage;
import ru.sakhnyuk.real.estate.storage.model.House;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JsonMapperServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void mapClassToJson() throws JsonProcessingException {
        House house = jdbcTemplate.queryForObject("""
                select * from real_estate.houses
                where id = 1;
                """, new BeanPropertyRowMapper<House>(House.class));
        ObjectMapper mapper = new ObjectMapper();
        String houseString = mapper.writeValueAsString(house);
        assertNotNull(houseString);
        assertEquals(houseString, "{\"id\":1,\"address\":\"Челюскинцев 20, 12\",\"city\":\"Ржев\",\"state\":\"Тверская область\",\"country\":\"Россия\"}");
    }
}