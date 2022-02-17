package com.infoshareacademy.controllers;


import com.infoshareacademy.domain.Car;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.InOutSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchCarController {

    private final InOutSearch services;
    private final Cars cars;

    @Autowired
    public SearchCarController(InOutSearch services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("/search-car")
    public String displaySearchedCars(@RequestParam("stringToFind") String stringToFind, Model model) {
        List<Car> CarSearchResult = services.returnListOfCarsToRepair(cars, stringToFind);
        model.addAttribute("carSearchResult", CarSearchResult);
        return "search-cars";
    }

    @GetMapping("/show-cars-to-repair")
    public String displayCarsToFix(Model model) {
        List<Car> CarSearchResult = services.returnListCarsToRepair(cars);
        model.addAttribute("carSearchResult", CarSearchResult);
        return "search-cars";
    }
}
