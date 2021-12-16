package com.infoshareacademy.controllers;

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
public class EditCarController {

    private final Services services;
    private Books books;
    private Integer bookToEditID;


    @Autowired
    public EditCarController(Services services, Books books) {
       this.services = services;
        this.books = books;
    }

    @RequestMapping(value = "/edit/{title}", method = RequestMethod.GET)
    public ModelAndView carEditForm(@PathVariable String title) {
        bookToEditID= services.findIFForTitle(books, title);
        ModelAndView modelAndView=new ModelAndView("EditCar");
        Book bookToEdit = books.getBooks().get(bookToEditID);
        modelAndView.addObject("carToEdit", bookToEdit);
        return modelAndView;
    }

    @PostMapping(value = "/save-edited-car")
    public String saveEditedCar(BookDto bookDto) {
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

        services.saveBookCase(books);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;
    }

}
