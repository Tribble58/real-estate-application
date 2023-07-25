package ru.sakhnyuk.real.estate.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import ru.sakhnyuk.real.estate.storage.DataStorage;
import ru.sakhnyuk.real.estate.storage.model.House;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RealEstateControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private DataStorage dataStorage;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testIndexEndpoint() {
        List<House> houses = restTemplate.getForObject("http://localhost:" + port + "/index", List.class);
        assertEquals(dataStorage.getHouses().size(), houses.size());
    }
}