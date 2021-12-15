package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.infoshareacademy.Utils.listToString;

@Controller
public class AllBooksController {

    private final Books books;

    @Autowired
    public AllBooksController(Books books) {
        this.books = books;
    }

    @GetMapping("all-books")
    public ModelAndView displayAllBooks() {
        ModelAndView modelAndView = new ModelAndView("AllBooks");
        modelAndView.addObject("allBooks", listToString(books.getBooks(), true));
        return modelAndView;
    }

}
