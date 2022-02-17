package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.InOutSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FixedCarsController {

    private final InOutSearch services;
    private final Cars cars;

    @Autowired
    public FixedCarsController(InOutSearch services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("fixed-cars")
    public String displayFixedCars(Model model) {
        List<Car> fixedCars = services.returnListOfRepairedCars(cars);
        model.addAttribute("fixedCars", fixedCars);
        return "fixed-cars";
    }
}
