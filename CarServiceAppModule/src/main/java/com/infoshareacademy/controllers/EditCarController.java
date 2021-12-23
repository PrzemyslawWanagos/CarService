package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EditCarController {

    private final Services services;
    private Cars cars;
    private Integer carToEditID;

    @Autowired
    public EditCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping(value = "/edit/{licencePlate}")
    public String carEditForm(@PathVariable String licencePlate, Model model) {
        carToEditID = services.FindByLicencePlate(cars, licencePlate);
        Car carToEdit = cars.getCars().get(carToEditID);
        CarDto carDto = new CarDto();
        services.fromEntityToDto(carToEdit, carDto);
        model.addAttribute("carDto", carDto);
        return "edit-car";
    }

    @PostMapping(value = "/edit/{licencePlate}")
    public String saveEditedCar(@Valid @ModelAttribute("carDto") CarDto carDto,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-car";
        }
        Car car = cars.getCars().get(carToEditID);
        try {
            services.fromDtoToEntity(carDto, car);
            car.setCostOfService(carDto.getCostOfService());
            car.setRepaired(true);
            car.setDateOfRepair(carDto.getDateOfRepair());
        } catch (Exception e) {
            return e.toString();
        }
        services.saveCarService(cars);
        String searchURL = "/all-cars";
        return "edit-car-success";
    }

}
