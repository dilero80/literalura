package com.alura.literalura.repository;

import com.alura.literalura.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    Book save(Book book);

    void deleteById(Long bookId);
}
