package com.alura.literalura.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String title;
    @JsonProperty
    private Set<Author> authors;
    @JsonProperty
    private ArrayList <String> bookshelves;
    @JsonProperty
    private ArrayList <String> languages;
    @JsonProperty
    private Boolean copyright;
    //@JsonProperty
    //private String media_type;
    //@JsonProperty
    //private ArrayList <String> formats;
    @JsonProperty
    private Integer download_count;

    public Book() {
        this.authors = new HashSet<>();
        this.bookshelves = new ArrayList<>();
        //this.formats = new ArrayList<>();
        this.languages = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "====================Book========================\n" +
               "id=" + id + "\n" +
               "Title = '" + title + "\n" +
               "Authors = \n" + authors + "\n" +
               "Languages = " + languages + "\n" +
               "Download_count = " + download_count + "\n" +
               "====================END=========================\n";
    }
}
