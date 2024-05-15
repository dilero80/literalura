package com.alura.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataMapper implements IDataMapper{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classType) {
        try {
            return objectMapper.readValue(json,classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
