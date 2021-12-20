package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AddCarController {

    private final Services services;
    private final Cars cars;
    private Car car = new Car();

    @Autowired
    public AddCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("add-car")
    public String createCar() {
        return "add-car";
    }

    @PostMapping(value = "add-car")

    public String saveAddedCar(@Valid @ModelAttribute("add-car") CarDto carDto,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "main";
        }
        try {
            car.setMake(carDto.getMake());
            car.setLicencePlate(carDto.getLicencePlate());
            car.setCostOfService(0);
            car.setCategory(carDto.getCategory());
            car.setRepaired(false);
            car.setDescription(carDto.getDescription());
        } catch (Exception e) {
            return e.toString();
        }
        cars.addCarToCarService(car);
        System.out.println(cars.toString()); //remove
        services.saveCarService(cars);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;

    }

}
