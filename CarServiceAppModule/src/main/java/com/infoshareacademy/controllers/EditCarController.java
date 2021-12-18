package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EditCarController {

    private final Services services;
    private Cars cars;
    private Integer CarToEditID;


    @Autowired
    public EditCarController(Services services, Cars cars) {
       this.services = services;
        this.cars = cars;
    }

    @RequestMapping(value = "/edit/{title}", method = RequestMethod.GET)
    public ModelAndView carEditForm(@PathVariable String title) {
        CarToEditID= services.FindByLicencePlate(cars, title);
        ModelAndView modelAndView=new ModelAndView("EditCar");
        Car CarToEdit = cars.getCars().get(CarToEditID);
        modelAndView.addObject("carToEdit", CarToEdit);
        return modelAndView;
    }

    @PostMapping(value = "/save-edited-car")
    public String saveEditedCar(CarDto carDto) {
                Car car = cars.getCars().get(CarToEditID);
        try {
            car.setMake(carDto.getMake());

            car.setLicencePlate(carDto.getLicencePlate());
            car.setCostOfService(carDto.getCostOfService());
            car.setCategory(carDto.getCategory());
            Boolean temp = carDto.getRepaired();
           car.setRepaired(temp);
        } catch (Exception e) {
            return e.toString();
        }

        services.saveCarService(cars);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;
    }

}
