package com.alura.literalura.repository;

import com.alura.literalura.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findByLanguagesLike(String language);

}
