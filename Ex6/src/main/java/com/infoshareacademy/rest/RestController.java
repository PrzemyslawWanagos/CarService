package com.infoshareacademy.rest;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("books")
public class RestController {
    @Autowired
    Books books;

    @GetMapping("/test")
    public Books getBookcase() {

        return books;
    }

    /*@GetMapping("novels/{isbn}")
    public BookDto getBook(@PathVariable Integer isbn,
                           @RequestParam(required = false, name = "tytul", defaultValue = "cool novel") String title) {
        BookDto bookDto = new BookDto();
        bookDto.setIsbn(isbn);
        bookDto.setTitle(title);
        return bookDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("novels")
    public BookDto create(@RequestBody BookDto bookDto) {
        // some code to save a book
        return bookDto;
    }*/

}
