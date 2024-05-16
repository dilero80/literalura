package com.alura.literalura.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CollectionType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @Id
    @JsonProperty
    private Integer id;
    @Column(unique = true)
    @JsonProperty
    private String title;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty
    private Set<Author> authors;
    @JsonProperty
    private List <String> bookshelves;
    @JsonProperty
    @ElementCollection
    private List<String> languages;
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
