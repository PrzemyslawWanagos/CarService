package com.infoshareacademy.rest;



import com.infoshareacademy.domain.Book;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.infoshareacademy.Utils.listToString;
//@org.springframework.web.bind.annotation.RestController
//@org.springframework.web.bind.annotation.RestController
@Controller
public class RestController {
@Autowired
    Books books;

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/all-books")
    @ResponseBody
    public String getBookcase() {
        return listToString(books.getBooks(), true);

    }

    @GetMapping("/book-for-today")
    @ResponseBody
    public String getBook() {
        Random random = new Random();

        Integer bookPosition = random.nextInt(books.getBooks().size());
        return books.getBooks().get(bookPosition).toString();
    }

    @GetMapping("book/{title}/search")
    @ResponseBody
    public String findBook(@PathVariable String title) {
        List<Book> toReturn = new ArrayList<>();       //                      @RequestParam(required = false, name = ""text"", defaultValue = "cool t-shirt") String name) {
        for (Book book : books.getBooks()) {
            if (book.getTitle().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT))) {
                toReturn.add(book);
            }
        }
        return listToString(toReturn, true);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
    public Book addBook() {
        Book duplicateBook;
        duplicateBook = books.getBooks().get(3);
        books.getBooks().add(new Book("Jan Brzechwa", "Lokomotywa", Category.LITERATURA_PIEKNA, 2, true));
        return duplicateBook;
        ////       books.toString();
    }
}
