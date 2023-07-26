package ru.sakhnyuk.real.estate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Deprecated
    @Autowired
    private JsonMapperService jsonMapper;

    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<House> index() {
        return dataStorage.getHouses();
    }
}
