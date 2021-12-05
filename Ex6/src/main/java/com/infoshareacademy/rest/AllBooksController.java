package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.infoshareacademy.Utils.listToString;


@Controller
public class AllBooksController {
    //Services services = new Services();
    @Autowired
    Books books;

    @GetMapping("/all-books")
    @ResponseBody
    public String getBookcase() {
        return listToString(books.getBooks(), true) + "<br> <br> <button onclick=\"window.location.href='http://localhost:8080/main';\">Main menu</button>";
    }


}
