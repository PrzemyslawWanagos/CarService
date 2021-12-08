package com.infoshareacademy.rest;


import com.infoshareacademy.domain.Book;
import com.infoshareacademy.dto.BookDto;
import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class BookAddController {
    private final Services services;
    private final Books books;
    private Book book = new Book();

    @Autowired
    public BookAddController(Services services, Books books) {
        this.services = services;
        this.books = books;
        // this.book = book;
    }

    @GetMapping("add-book")
    public String createBook() {

        return "AddBook";
    }
//
//    @PostMapping("/books/add")
//    public ModelAndView displayBooks(@RequestParam("title") String title) {
//        ModelAndView modelAndView = new ModelAndView("AddBook");
//        modelAndView.addObject("bookSearchResult", services.browseThroughBooks(books, title));
//        return modelAndView;
//    }

    @PostMapping(value = "books/add")
    @ResponseBody
    public String create(BookDto bookDto) {

        try {
            book.setAuthor(bookDto.getAuthor());
            book.setTitle(bookDto.getTitle());
            book.setPages(bookDto.getPages());
            book.setCategory(bookDto.getCategory());
            Boolean temp=bookDto.isForKids();
            book.setForKids(temp);
        } catch (Exception e) {
            System.out.println("cos nie tak");
        }
        books.addBookToBookcase(book);
        services.saveBookCase(books);
        return books.toString();
    }


}
