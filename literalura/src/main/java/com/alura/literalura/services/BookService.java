package com.alura.literalura.services;

import com.alura.literalura.entities.Author;
import com.alura.literalura.entities.Book;
import com.alura.literalura.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class BookService {
    private final BookRepository bookRepository;

    public Set<Book> books;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.books = new HashSet<>();
    }

    public BookService() {

    }

    public void createBooks (Optional<String> json, AuthorService as) throws JsonProcessingException {
        if (json.isPresent()){
            DataMapper mapper = new DataMapper();
            ObjectMapper objectMapper = new ObjectMapper();
            Book book = new Book();

            JsonNode rootNode = objectMapper.readTree(json.get());
            JsonNode booksNode = rootNode.get("results");
            for (JsonNode bookNode : booksNode) {

                book = mapper.getData(bookNode.toString(), Book.class);
                System.out.println(book);
                books.add(book);
                HashSet<Author> authors = (HashSet<Author>) books.stream()
                        .flatMap(book1 -> book1.getAuthors().stream())
                        .collect(Collectors.toSet());
                authors.
                        forEach(as::updateAuthors);
                }
        }
    }

    public void showBooks() {
        System.out.println(books);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
