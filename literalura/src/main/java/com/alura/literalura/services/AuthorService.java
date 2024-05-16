package com.alura.literalura.services;

import com.alura.literalura.entities.Author;
import com.alura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AuthorService {
    public final HashSet<Author> authors;
    public AuthorService() {
        this.authors = new HashSet<>();
    }

    public void updateAuthors(Author author){
        this.authors.add(author);
    }
    public void showAuthors(){
        authors.stream().forEach(System.out::println);
    }
}
