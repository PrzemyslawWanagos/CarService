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
public class SearchCarController {

    private final Services services;
    private final Cars cars;

    @Autowired
    public SearchCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("/search-car")
    public ModelAndView displaySearchedCars(@RequestParam("licencePlate") String licencePlate) {
        List<Car> CarSearchResult= services.returnListOfCarsToRepair(cars, licencePlate);
        ModelAndView modelAndView = new ModelAndView("search-cars");
//
//        System.out.println(listToString(CarSearchResult,true));
        modelAndView.addObject("carSearchResult",CarSearchResult);

        return modelAndView;
    }

}
