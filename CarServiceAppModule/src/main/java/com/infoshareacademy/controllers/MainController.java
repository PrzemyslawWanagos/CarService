package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.infoshareacademy.CarServiceApp.exception;


@Controller
public class MainController {

    private final Cars cars;

    @Autowired
    public MainController(Cars cars) {
        this.cars = cars;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        try {
            cars.setCars(Services.readCarService().getCars());
        } catch (Exception e) {
            if (exception.equals("zero length input")) {
                model.addAttribute("exception", exception);
                return "main";
            }
            exception = e.toString();
            return "redirect:/error/ERROR WHILE READING THE FILE 'CARS.JSON'!!!";
        }
        return "main";
    }
}
