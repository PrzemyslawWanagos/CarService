package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AllCarsController {

    private final Services services;
    private final Cars cars;
    @Autowired
    public AllCarsController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("all-cars")
    public ModelAndView displayAllCars() {

        ModelAndView modelAndView = new ModelAndView("AllCars");
        modelAndView.addObject("allCars", cars.getCars());
        return modelAndView;
    }

}
