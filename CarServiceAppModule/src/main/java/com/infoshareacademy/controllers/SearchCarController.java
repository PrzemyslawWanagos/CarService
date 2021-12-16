package com.infoshareacademy.controllers;


import com.infoshareacademy.domain.Book;
import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchCarController {

    private final Services services;
    private final Books books;

    @Autowired
    public SearchCarController(Services services, Books books) {
        this.services = services;
        this.books = books;
    }

    @GetMapping("/search-car")
    public ModelAndView displaySearchedCars(@RequestParam("title") String title) {
        List<Book> bookSearchResult= services.returnListOfBooks(books, title);
        ModelAndView modelAndView = new ModelAndView("SearchCar");
//
//        System.out.println(listToString(bookSearchResult,true));
        modelAndView.addObject("carSearchResult",bookSearchResult);

        return modelAndView;
    }

}
