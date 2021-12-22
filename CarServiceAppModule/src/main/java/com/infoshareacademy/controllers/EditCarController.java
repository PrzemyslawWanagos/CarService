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
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static com.infoshareacademy.Utils.listToString;

@Controller
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EditCarController {

    private final Services services;
    private Cars cars;
    private Integer carToEditID;
    private String tempDate=null;

    @Autowired
    public EditCarController(Services services, Cars cars) {
       this.services = services;
        this.cars = cars;
    }
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @RequestMapping(value = "/edit/{licencePlate}", method = RequestMethod.GET)
    public ModelAndView carEditForm(@PathVariable String licencePlate) {
        carToEditID = services.FindByLicencePlate(cars, licencePlate);
        Car carToEdit = cars.getCars().get(carToEditID);
        CarDto carDto=new CarDto();
        services.fromEntityToDto(carToEdit,carDto);
       if(tempDate!=null) {carDto.setDateOfRepair(tempDate);
        tempDate=null;}
        carDto.setCostOfService(0);
       carDto.setRepaired(false);
        ModelAndView modelAndView=new ModelAndView("edit-cars");
        modelAndView.addObject("carDto", carDto);
        return modelAndView;
    }

    @PostMapping(value = "/edit/{licencePlate}")
    public String saveEditedCar(@Valid @ModelAttribute("carDto") CarDto carDto,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            tempDate=carDto.getDateOfRepair();
           List<ObjectError> errors = bindingResult.getAllErrors();
            System.out.println(listToString(errors,true));
            return "edit-cars";
        }
                Car car = cars.getCars().get(carToEditID);
        try {
            services.fromDtoToEntity(carDto,car);
            car.setCostOfService(carDto.getCostOfService());
           car.setRepaired(true);
           car.setDateOfRepair(carDto.getDateOfRepair());
        } catch (Exception e) {
            return e.toString();
        }

        services.saveCarService(cars);
        String searchURL = "/all-cars";
        return "redirect:" + searchURL;
    }

}
