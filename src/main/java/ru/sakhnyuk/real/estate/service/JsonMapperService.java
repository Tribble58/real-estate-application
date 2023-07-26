package ru.sakhnyuk.real.estate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.sakhnyuk.real.estate.storage.model.House;

import java.util.List;

@Deprecated
@Service
public class JsonMapperService {

    public String mapClassToJson(List<House> houses) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(houses);
    }

    public String mapClassToJson(House house) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(house);
    }
}
