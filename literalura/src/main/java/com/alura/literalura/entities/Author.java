package com.alura.literalura.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
