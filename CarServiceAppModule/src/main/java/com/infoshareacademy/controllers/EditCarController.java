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
    private Integer bookToEditID;


    @Autowired
    public EditCarController(Services services, Cars cars) {
       this.services = services;
        this.cars = cars;
    }

    @RequestMapping(value = "/edit/{title}", method = RequestMethod.GET)
    public ModelAndView carEditForm(@PathVariable String title) {
        bookToEditID= services.findIFForTitle(cars, title);
        ModelAndView modelAndView=new ModelAndView("EditCar");
        Car bookToEdit = cars.getCars().get(bookToEditID);
        modelAndView.addObject("carToEdit", bookToEdit);
        return modelAndView;
    }

    @PostMapping(value = "/save-edited-car")
    public String saveEditedCar(CarDto carDto) {
                Car car = cars.getCars().get(bookToEditID);
        try {
            car.setMake(carDto.getMake());

            car.setLicencePlate(carDto.getLicencePlate());
            car.setPages(carDto.getPages());
            car.setCategory(carDto.getCategory());
            Boolean temp = carDto.isForKids();
           car.setForKids(temp);
        } catch (Exception e) {
            return e.toString();
        }

        services.saveBookCase(cars);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;
    }

}
