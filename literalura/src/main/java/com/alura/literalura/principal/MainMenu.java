package com.alura.literalura.principal;

import com.alura.literalura.services.BookRequest;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import com.alura.literalura.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MainMenu {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    BookRequest bookRequest = new BookRequest();
    BookService bs = new BookService();
    public MainMenu() throws JsonProcessingException {

        displayPrincipalMenu();
        switchMenu();


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
            option = selectOption();
            switch (option){
                case 1:
                    getBook();
                    bs.showBooks();
                    break;
                case 2:
                    break;
                case 3:
                    break;



            }
        }while(option != 4);
    }

    private void getBook() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Enter Book Name");
        Optional<String> booksJson = Optional.ofNullable(bookRequest.getBooks(read.next().toLowerCase(Locale.ROOT)));
        bs.createBooks(booksJson);




    }




}