package com.infoshareacademy.rest;

import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.infoshareacademy.Utils.listToString;

@Controller
public class BookEditController {

    private final Books books;

    @Autowired
    public BookEditController(Books books) {
        this.books = books;
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public String BookEdit(Model model) {
//        String a=books.getBooks().get(2).author;
//        System.out.println(a);
//        model.addAttribute("author",a);
//
//       // modelAndView.addObject("testAttribute", "This is test attribute");
//        return "BookEdit";
//    }

}
