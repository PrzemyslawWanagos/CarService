package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Book;
import com.infoshareacademy.dto.BookDto;
import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AddCarController {

    private final Services services;
    private final Books books;
    private Book book = new Book();

    @Autowired
    public AddCarController(Services services, Books books) {
        this.services = services;
        this.books = books;
    }

    @GetMapping("add-car")
    public String createCar() {
        return "AddCar";
    }

    @PostMapping(value = "save-added-car")

    public String saveAddedCar(BookDto bookDto) {
        try {
            book.setAuthor(bookDto.getAuthor());
            book.setTitle(bookDto.getTitle());
            book.setPages(bookDto.getPages());
            book.setCategory(bookDto.getCategory());
            Boolean temp = bookDto.isForKids();
            book.setForKids(temp);
        } catch (Exception e) {
            return e.toString();
        }
        books.addBookToBookcase(book);
        services.saveBookCase(books);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;

    }

}
