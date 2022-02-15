package com.infoshareacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.infoshareacademy.CarServiceApp.exception;

@Controller

public class ErrorController {

    @GetMapping("error/{errorName}")
    public String displayError(@PathVariable String errorName, Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("errorName", errorName);
        exception = null;
        return "error-message";
    }
}
