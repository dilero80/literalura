package com.alura.literalura.services;

public interface IDataMapper {
    <T> T getData(String json, Class<T> classType);
}
