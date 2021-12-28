package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

import static com.infoshareacademy.CarServiceApp.exception;

@Controller

public class ErrorController {

    private final Services services;
    private final Cars cars;


    @Autowired
    public ErrorController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("error/{errorName}")
    public String displayError (@PathVariable String errorName, Model model) {
        model.addAttribute("exception",exception.toString());
        model.addAttribute("errorName",errorName);
        exception=null;
        return "error";
    }
}
