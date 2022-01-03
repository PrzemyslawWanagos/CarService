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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

import java.time.LocalDate;

import static com.infoshareacademy.CarServiceApp.exception;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AddCarController {

    private final Services services;
    private final Cars cars;
    private boolean duplicateLicencePlate;

    @Autowired
    public AddCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
        duplicateLicencePlate=false;
    }

    @GetMapping("add-car")
    public String createCarForm(Model model) {
        model.addAttribute("carDto", new CarDto());
       // model.addAttribute("duplicateLicencePlate", duplicateLicencePlate);

        return "add-car";
    }

    @PostMapping(value = "add-car")
    public String saveCreatedCar(@Valid @ModelAttribute("carDto") CarDto carDto,
                               BindingResult bindingResult) {
        Car car = new Car();
        if (bindingResult.hasErrors()) {
            return "add-car";
        }
        if (services.FindByLicencePlate(cars, carDto.getLicencePlate()) != null) {
            carDto.setDuplicateLicencePlateError(true);
            return "add-car";
        } else {
            carDto.setDuplicateLicencePlateError(false);
        }

        String currentDate = LocalDate.now().toString();
        Integer currentYear=Integer.parseInt(currentDate.substring(0,4));
        Integer enteredDate=Integer.parseInt(carDto.getServiceStartDate().substring(0,4));

        if ((enteredDate>currentYear)||(enteredDate<currentYear-1)) {
            carDto.setServiceStartDateError(true);
            return "add-car";
        } else {
            carDto.setServiceStartDateError(false);
        }

        try {
            services.fromDtoToEntity(carDto, car);
        } catch (Exception e) {
            return e.toString();
        }
        cars.addCarToCarService(car);
        services.saveCarService(cars);
        if(exception!=null){
        return "redirect:/error/Error while adding the car";
        }
        return "add-car-success";

    }


}
