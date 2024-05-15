package com.alura.literalura.services;

import com.alura.literalura.entities.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BookService {

    public Set<Book> books;

    public BookService() {
        this.books = new HashSet<>();
    }

    public void createBooks (Optional<String> json) throws JsonProcessingException {
        if (json.isPresent()){
            Book book = new Book();
            DataMapper mapper = new DataMapper();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json.get());
            JsonNode booksNode = rootNode.get("results");
            for (JsonNode bookNode : booksNode) {
                System.out.println(bookNode);
                books.add(mapper.getData(bookNode.toString(),book.getClass()));
            }







        }





    }

    public void showBooks() {
        System.out.println(books);
    }
}
