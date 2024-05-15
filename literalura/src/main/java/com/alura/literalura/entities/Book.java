package com.alura.literalura.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.Optional;

@Data
public class Book {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String title;
    @JsonProperty
    private ArrayList <String> authors;
    @JsonProperty
    private ArrayList <String> bookshelves;
    @JsonProperty
    private ArrayList <String> languages;
    @JsonProperty
    private Optional<Boolean> copyright;
    @JsonProperty
    private ArrayList <String> media_type;
    @JsonProperty
    private ArrayList <String> formats;
    @JsonProperty
    private Integer download_count;

    @Override
    public String toString() {
        return "====================Book========================\n" +
               "id=" + id + "\n" +
               "Title = '" + title + "\n" +
               "Authors = " + authors + "\n" +
               "Languages = " + languages + "\n" +
               "Download_count = " + download_count + "\n" +
               "====================END=========================";
    }
}
