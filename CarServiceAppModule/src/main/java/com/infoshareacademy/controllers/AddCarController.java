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
import java.util.Objects;

import static com.infoshareacademy.CarServiceApp.exception;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AddCarController {

    private final Services services;
    private final Cars cars;

    @Autowired
    public AddCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping("add-car")
    public String createCarForm(Model model) {
        CarDto carDto= new CarDto();
        carDto.setServiceStartDate("2022-02-15");
        model.addAttribute("carDto", carDto);
        return "add-car";
    }

    @PostMapping(value = "add-car")
    public String saveCreatedCar(@Valid @ModelAttribute("carDto") CarDto carDto,
                                 BindingResult bindingResult) {
        Car car = new Car();
        if (bindingResult.hasErrors()) {
            return "add-car";
        }
        if (Objects.nonNull(cars.getCars())) {
            if (services.FindByLicencePlate(cars, carDto.getLicencePlate()) != null) {
                carDto.setDuplicateLicencePlateError(true);
                return "add-car";
            } else {
                carDto.setDuplicateLicencePlateError(false);
            }
        }
        String currentDate = LocalDate.now().toString();
        int currentYear = Integer.parseInt(currentDate.substring(0, 4));
        int enteredDate = Integer.parseInt(carDto.getServiceStartDate().substring(0, 4));
        if ((enteredDate > currentYear) || (enteredDate < currentYear - 1)) {
            carDto.setServiceStartDateError(true);
            return "add-car";
        } else {
            carDto.setServiceStartDateError(false);
        }
        try {
            services.fromDtoToEntity(carDto, car);
            cars.addCarToCarService(car);
            services.saveCarService(cars);
        } catch (Exception e) {
            exception = e.toString();
            return "redirect:/error/ERROR WHILE ADDING NEW CAR!!!";
        }
        return "add-car-success";
    }
}
