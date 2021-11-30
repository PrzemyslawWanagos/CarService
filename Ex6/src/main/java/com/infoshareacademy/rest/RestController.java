package com.infoshareacademy.rest;

import com.infoshareacademy.domain.Book;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Random;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("books")
public class RestController {
    @Autowired
    Books books;
//    @Autowired
//    Book book;

    @GetMapping("/test")
    public Books getBookcase() {

        return books;
    }

    @GetMapping("/book-for-today")
    public Book getBook() {
        Random random = new Random();

        Integer bookPosition = random.nextInt(books.getBooks().size());
        return books.getBooks().get(bookPosition);
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
public Book addBook() {
      Book duplicateBook;
      duplicateBook=books.getBooks().get(3);
      books.getBooks().add(new Book("Jan Brzechwa","Lokomotywa", Category.LITERATURA_PIEKNA,2,true));
        return duplicateBook;
      ////       books.toString();
   }
}
