package com.alura.literalura.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    @JsonProperty
    private String name;
    @JsonProperty
    private Integer birth_year;
    @JsonProperty
    private Integer death_year;
}
