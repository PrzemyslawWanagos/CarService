package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.infoshareacademy.Utils.listToString;


@Controller
public class BookForToday {
    private final Services services;
    private final Books books;

    @Autowired
    public BookForToday(Services services, Books books) {
        this.services = services;
        this.books = books;
    }

    @GetMapping("/book-for-today")
    @ResponseBody
    public String getBook() {
        return services.getRandomBook(books);
    }

}
