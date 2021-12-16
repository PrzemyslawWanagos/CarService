package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.infoshareacademy.Utils.listToString;

@Controller
public class AllCarsController {

    private final Cars cars;

    @Autowired
    public AllCarsController(Cars cars) {
        this.cars = cars;
    }

    @GetMapping("all-cars")
    public ModelAndView displayAllBooks() {
        ModelAndView modelAndView = new ModelAndView("AllCars");
        modelAndView.addObject("allCars", listToString(cars.getCars(), true));
        return modelAndView;
    }

}
