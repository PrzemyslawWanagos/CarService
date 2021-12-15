package com.infoshareacademy.controllers;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookForTodayController {

    private final Services services;
    private final Books books;

    @Autowired
    public BookForTodayController(Services services, Books books) {
        this.services = services;
        this.books = books;
    }

    @GetMapping("/book-for-today")
    public ModelAndView displayBookForToday() {
        ModelAndView modelAndView = new ModelAndView("BookForToday");
        modelAndView.addObject("bookForToday", services.getRandomBook(books));
        return modelAndView;
    }

}
