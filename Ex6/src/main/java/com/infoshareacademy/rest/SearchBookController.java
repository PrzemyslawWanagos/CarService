package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchBookController {

    private final Services services;
    private final Books books;

    @Autowired
    public SearchBookController(Services services, Books books) {
        this.services = services;
        this.books = books;
    }

    @GetMapping("/search-book")
    public ModelAndView displaySearchedBooks(@RequestParam("title") String title) {
        ModelAndView modelAndView = new ModelAndView("SearchBook");
        modelAndView.addObject("bookSearchResult", services.browseThroughBooks(books, title));
        return modelAndView;
    }

}
