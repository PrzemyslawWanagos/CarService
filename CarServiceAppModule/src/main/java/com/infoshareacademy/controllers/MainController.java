package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

import static com.infoshareacademy.CarServiceApp.exception;


@Controller
public class MainController {

    private final Cars cars;

    @Autowired
    public MainController(Cars cars) {
        this.cars = cars;
    }

    @GetMapping("/")
    public String mainPage() {
        try {
            cars.setCars(Services.readCarService().getCars());
        } catch (IOException e) {
            exception = e;
            return "redirect:/error/ERROR WHILE READING THE FILE 'CARS.JSON'!!!";
        }
        return "main";
    }
}
