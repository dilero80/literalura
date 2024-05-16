package com.alura.literalura.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @JsonProperty
    private String name;
    @JsonProperty
    private Integer birth_year;
    @JsonProperty
    private Integer death_year;


    @Override
    public String toString() {
        return "=================Author==================\n" +
                "Name= " + name + "\n" +
                "Birth_year= " + birth_year + "\n"+
                "Death_year= " + death_year + "\n" +
                "========================================\n";
    }
}
