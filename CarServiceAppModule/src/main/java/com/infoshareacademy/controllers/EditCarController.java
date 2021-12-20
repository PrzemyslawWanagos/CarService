package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
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

    @RequestMapping(value = "/edit/{licencePlate}", method = RequestMethod.GET)
    public ModelAndView carEditForm(@PathVariable String licencePlate) {
        CarToEditID= services.FindByLicencePlate(cars, licencePlate);
        ModelAndView modelAndView=new ModelAndView("edit-cars");
        Car CarToEdit = cars.getCars().get(CarToEditID);
        modelAndView.addObject("carDto", CarToEdit);
        return modelAndView;
    }

    @PostMapping(value = "/edit/{licencePlate}")
    public String saveEditedCar(CarDto carDto) {
                Car car = cars.getCars().get(CarToEditID);
        try {
            car.setMake(carDto.getMake());

            car.setLicencePlate(carDto.getLicencePlate());
            car.setCostOfService(carDto.getCostOfService());
            car.setCategory(carDto.getCategory());

           car.setRepaired(true);
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            Date parsed = format.parse();
//            System.out.println(carDto.getDateOfRepair());
//            LocalDate date = LocalDate.parse("2018-09-16");
           car.setDateOfRepair(carDto.getDateOfRepair());
        } catch (Exception e) {
            return e.toString();
        }

        services.saveCarService(cars);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;
    }

}
