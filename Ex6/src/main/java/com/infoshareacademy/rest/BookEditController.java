package com.infoshareacademy.rest;

import com.infoshareacademy.domain.Book;
import com.infoshareacademy.dto.BookDto;
import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static com.infoshareacademy.Utils.listToString;

@Controller
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BookEditController {

    private final Services services;
    private Books books;
    private Integer bookToEditID;


    @Autowired
    public BookEditController(Services services, Books books) {
       this.services = services;
        this.books = books;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String bookEdit(Model model, @PathVariable Integer id) {
        bookToEditID=id;
        String a=books.getBooks().get(bookToEditID).author;
        System.out.println(bookToEditID+" "+id);
        System.out.println(a);
        model.addAttribute("author",a);

       // modelAndView.addObject("testAttribute", "This is test attribute");
        return "BookEdit";
    }
    @PostMapping(value = "/edit2")

    public String saveEditedBook(BookDto bookDto) {
        System.out.println(bookToEditID);
        System.out.println(bookDto);
        Book book=books.getBooks().get(bookToEditID);
        try {
            book.setAuthor(bookDto.getAuthor());
            //book.setAuthor(bookDto.getAuthor());
//            book.setTitle(bookDto.getTitle());
//            book.setPages(bookDto.getPages());
//            book.setCategory(bookDto.getCategory());
//            Boolean temp = bookDto.isForKids();
//            book.setForKids(temp);
        } catch (Exception e) {
            System.out.println(e);
        }
       // books.addBookToBookcase(book);
        services.saveBookCase(books);
        String searchURL = "/all-books";
        return "redirect:" + searchURL;
    }

}
