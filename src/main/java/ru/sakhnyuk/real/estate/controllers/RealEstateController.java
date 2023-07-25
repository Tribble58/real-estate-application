package ru.sakhnyuk.real.estate.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sakhnyuk.real.estate.service.JsonMapperService;
import ru.sakhnyuk.real.estate.storage.DataStorage;
import ru.sakhnyuk.real.estate.storage.model.House;

import java.util.List;

@RestController
public class RealEstateController {

    @Autowired
    private DataStorage dataStorage;

    @Autowired
    private JsonMapperService jsonMapper;

    @GetMapping(value = "/index", produces = "application/json")
    public String index() throws JsonProcessingException {
        List<House> houses = dataStorage.getHouses();
        return jsonMapper.mapClassToJson(houses);
    }
}
