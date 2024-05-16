package com.alura.literalura.services;

import com.alura.literalura.entities.Author;

import com.alura.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository ar;
    public final HashSet<Author> authors;

    public AuthorService() {
        this.authors = new HashSet<>();
    }

    public void updateAuthors(Author author){
        ar.save(author);
        this.authors.add(author);


    }
    public void showAuthors(){
        authors.stream().forEach(System.out::println);
    }

    public void getAllAuthors(){
        List<Author> authors1 = ar.findAll();
        authors.addAll(authors1);
        showAuthors();
    }


}
