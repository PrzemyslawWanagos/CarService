package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.infoshareacademy.CarServiceApp.exception;

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
    public String displayAllCars(Model model) {
        List<Car> listOfCars;

           listOfCars = cars.getCars();
    if(listOfCars==null){

            exception=new NullPointerException();
            return "redirect:/error/ERROR WHILE ACCESSING THE LIST OF ALL CARS!!!";
        }
        model.addAttribute("allCars", listOfCars);
        return "all-cars";
    }


}
