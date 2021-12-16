package com.infoshareacademy.controllers;


import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookForTodayController {

    private final Services services;
    private final Cars cars;

    @Autowired
    public BookForTodayController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("/book-for-today")
    public ModelAndView displayBookForToday() {
        ModelAndView modelAndView = new ModelAndView("BookForToday");
        modelAndView.addObject("bookForToday", services.getRandomBook(cars));
        return modelAndView;
    }

}
