package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.infoshareacademy.Utils.listToString;


@Controller
public class BookSearchController {
    private final Services services;
    private final Books books;

    @Autowired
    public BookSearchController(Services services, Books books) {
        this.services = services;
        this.books = books;
    }


    @GetMapping("/book/{title}/search")
    @ResponseBody
    public String findBook(@PathVariable String title) {
        return services.browseThroughBooks(books, title);
    }

    //below method to redirect from html form to correct address. Maybe it can be done better...
    @RequestMapping("/search")
    public String display(@RequestParam("title") String title) {
            String searchURL = "http://localhost:8080/book/"+title+"/search";
        return "redirect:" + searchURL;
    }
}
