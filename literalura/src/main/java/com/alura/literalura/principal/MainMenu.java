package com.alura.literalura.principal;


import com.alura.literalura.services.AuthorService;
import com.alura.literalura.services.BookRequest;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import com.alura.literalura.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class MainMenu {
    private Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    private BookRequest bookRequest = new BookRequest();
    private final BookService bs;
    private final AuthorService as;

    public MainMenu(BookService bookService, AuthorService authorService) {
        this.bs = bookService;
        this.as = authorService;
    }

    private int selectOption() {
        System.out.println("Digit your option : ");
        return read.nextInt();
    }

    public void displayPrincipalMenu(){
        System.out.println("========================================");
        System.out.println("----- PRINCIPAL MENU-----");
        System.out.println("1. FIND BOOK BY TITLE MENU");
        System.out.println("2. LIST REGISTERED BOOKS ON DB");
        System.out.println("3. LIST REGISTERED AUTHORS");
        System.out.println("4. LIST BOOKS BY LANGUAGE");
        System.out.println("5. EXIT");
        System.out.println("========================================");
    }

    public void switchMenu() throws JsonProcessingException {
        int option;
        do {
            displayPrincipalMenu();
            option = selectOption();
            switch (option){
                case 1:
                    getBook();
                    break;
                case 2:
                    bs.getAllBooks();
                    break;
                case 3:
                    as.getAllAuthors();
                    break;
                case 4:
                    bs.getBooksByLanguage();
                    break;



            }
        }while(option != 5);
    }

    private void getBook() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Enter Book Name");
        Optional<String> booksJson = Optional.ofNullable(bookRequest.getBooks(read.next().toLowerCase(Locale.ROOT)));
        bs.createBooks(booksJson, as);
    }




}
