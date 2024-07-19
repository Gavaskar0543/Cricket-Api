package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
    private String jsonString;
    private ObjectMapper objectMapper;

    //constructor
    public JsonConverter(String str) {
        this.jsonString = str;
        this.objectMapper = new ObjectMapper();
    }

    public ApiResponse convert() throws JsonProcessingException {
        return objectMapper.readValue(this.jsonString, ApiResponse.class);
    }
}
