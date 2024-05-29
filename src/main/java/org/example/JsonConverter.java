package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class JsonConverter {
    private String jsonString;
    private ObjectMapper objectMapper;

    public JsonConverter(String str) {
        this.jsonString = str;
        this.objectMapper = new ObjectMapper();
    }

    public List<Match> convert() throws JsonProcessingException {
        return objectMapper.readValue(this.jsonString, new TypeReference<List<Match>>(){});
    }
}
