package com.alura.literalura.services;

import com.alura.literalura.entities.Author;
import com.alura.literalura.entities.Book;
import com.alura.literalura.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Set<Book> books = new HashSet<>();

    private Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    @Transactional()
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
                bookRepository.save(book);
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

    @Transactional()
    public void getAllBooks() {

        List<Book> books1 = bookRepository.findAll();
        books1.forEach(books::add);
        showBooks();
    }

    @Transactional
    public void getBooksByLanguage() {
        System.out.println("Enter language");
        String language = read.next();
        ArrayList<String> languages = new ArrayList<>();
        languages.add(language);
        System.out.println(languages);
        //List<String> languages = Collections.singletonList(language);
        List<Book> books1 = bookRepository.findByLanguagesLike(language);
        books1.forEach(System.out::println);


    }
}
