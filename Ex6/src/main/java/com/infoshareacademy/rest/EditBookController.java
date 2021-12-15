package com.infoshareacademy.rest;

import com.infoshareacademy.domain.Book;
import com.infoshareacademy.dto.BookDto;
import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EditBookController {

    private final Services services;
    private Books books;
    private Integer bookToEditID;


    @Autowired
    public EditBookController(Services services, Books books) {
       this.services = services;
        this.books = books;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView bookEditForm(@PathVariable Integer id) {
        bookToEditID=id;
        ModelAndView modelAndView=new ModelAndView("EditBook");
        Book bookToEdit = books.getBooks().get(bookToEditID);
        modelAndView.addObject("bookToEdit", bookToEdit);

//        String a=books.getBooks().get(bookToEditID).author;
//        System.out.println(bookToEditID+" "+id);
//        System.out.println(a);
//        model.addAttribute("author",a);

       // modelAndView.addObject("testAttribute", "This is test attribute");
        return modelAndView;
    }
    @PostMapping(value = "/save-edited-book")

    public String saveEditedBook(BookDto bookDto) {
        System.out.println(bookToEditID);
        System.out.println(bookDto);
        Book book=books.getBooks().get(bookToEditID);
        try {
            book.setAuthor(bookDto.getAuthor());

            book.setTitle(bookDto.getTitle());
            book.setPages(bookDto.getPages());
            book.setCategory(bookDto.getCategory());
            Boolean temp = bookDto.isForKids();
           book.setForKids(temp);
        } catch (Exception e) {
            return e.toString();
        }
       // books.addBookToBookcase(book);
        services.saveBookCase(books);
        String searchURL = "/all-books";
        return "redirect:" + searchURL;
    }

}
