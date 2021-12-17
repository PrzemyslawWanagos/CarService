package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.infoshareacademy.CarServiceApp.exitApp;


@Controller
public class MainController {

    private final Cars cars;

    @Autowired
    public MainController(Services services, Cars cars) {
        this.cars = cars;
    }

    @GetMapping("/main")
    public String mainPage() {
        cars.setCars(Services.readCarService().getCars());
        return "Main";
    }

    @GetMapping("/exit")
    @ResponseBody
    public void exit() {
        try {
            exitApp();
        } catch (Exception e) {
        }
    }

}
