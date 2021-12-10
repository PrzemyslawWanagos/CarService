package com.infoshareacademy.rest;

import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.infoshareacademy.BookcaseApp.exitApp;


@Controller
public class BookCaseController {

    private final Books books;

    @Autowired
    public BookCaseController(Services services, Books books) {
        this.books = books;
    }

    @GetMapping("/main")
    public String mainPage() {
        books.setBooks(Services.readBookCase().getBooks());
        return "main";
    }

    @GetMapping("/exit")
    @ResponseBody
    public void exit() {
        try {
            exitApp();
        } catch (Exception e) {
        }
    }

}
