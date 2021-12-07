package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.infoshareacademy.Utils.listToString;


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
    public ModelAndView displayBooks() {
        ModelAndView modelAndView = new ModelAndView("BookForToday");
        modelAndView.addObject("bookForToday", services.getRandomBook(books));
       // modelAndView.addObject("testAttribute","This is test attribute");
        return modelAndView;
    }
//    @GetMapping("/book-for-today")
//    @ResponseBody
//    public String getBook() {
//        return services.getRandomBook(books);
//    }

}
