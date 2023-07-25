package ru.sakhnyuk.real.estate.storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DataStorageTest {

    @Autowired
    private DataStorage dataStorage;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetHouseIsNotNull() throws Exception {
        assertNotNull(dataStorage.getHouses());
    }

    @Test
    public void testGetHouseHasData() throws Exception {
        assertEquals(dataStorage.getHouses().size(), 2);
    }

    @Test
    public void testGetHouseData() throws Exception {
        assertEquals(dataStorage.getHouses().get(0).getCountry(), "Россия");
    }

    @Test
    public void testTemplate() {
        SqlRowSet rowsCount = jdbcTemplate.queryForRowSet("select count(*) from real_estate.houses");
        rowsCount.next();
        assertEquals(rowsCount.getInt(1), 2);
    }
}