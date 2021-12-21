package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;




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
        return "main";
    }

    @GetMapping("/exit")
    @ResponseBody
    public void exit() {
        try {
            //xxx
        } catch (Exception e) {
        }
    }

}
