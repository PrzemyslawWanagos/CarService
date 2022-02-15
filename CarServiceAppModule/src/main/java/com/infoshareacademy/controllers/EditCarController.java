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
import java.time.LocalDate;

import static com.infoshareacademy.CarServiceApp.exception;

@Controller
public class EditCarController {

    private final Services services;
    private final Cars cars;

    @Autowired
    public EditCarController(Services services, Cars cars) {
        this.services = services;
        this.cars = cars;
    }

    @GetMapping(value = "/edit/{licencePlate}")
    public String editCarForm(@PathVariable String licencePlate, Model model) {
        CarDto carDto = new CarDto();
        try {
            Car carToEdit = services.FindByLicencePlate(cars, licencePlate);
            services.fromEntityToDto(carToEdit, carDto);
        } catch (Exception e) {
            exception = e.toString();
            return "redirect:/error/ERROR WHILE LOOKING FOR CAR BY LICENCE PLATE";
        }
        model.addAttribute("carDto", carDto);
        return "edit-car";
    }

    @PostMapping(value = "/edit/{licencePlate}")
    public String saveEditedCar(@Valid @ModelAttribute("carDto") CarDto carDto,
                                BindingResult bindingResult) {
        Car car;
        try {
            car = services.FindByLicencePlate(cars, carDto.getLicencePlate());
            checkIfDateOfRepairHasErrors(carDto, car);
            if (bindingResult.hasErrors() || !(carDto.getDateOfRepairError().isEmpty())) {
                return "edit-car";
            }
            services.fromDtoToEntity(carDto, car);
            car.setCostOfService(carDto.getCostOfService());
            car.setRepaired(true);
            car.setDateOfRepair(carDto.getDateOfRepair());
            services.saveCarService(cars);
        } catch (Exception e) {
            return "redirect:/error/Error while updating the list of cars";
        }
        try {
            services.saveRepairedCarList(cars, car.getDateOfRepair());
        } catch (Exception e) {
            return "redirect:/error/Error while updating the list of repaired cars";
        }
        return "edit-car-success";
    }

    private void checkIfDateOfRepairHasErrors(CarDto carDto, Car car) {
        String currentDate = LocalDate.now().toString();
        int currentYear = Integer.parseInt(currentDate.substring(0, 4));
        int enteredDate = Integer.parseInt(carDto.getDateOfRepair().substring(0, 4));
        if ((enteredDate > currentYear) || (enteredDate < currentYear - 1)) {
            carDto.setDateOfRepairError("You can only select current and prior year");
        } else {
            carDto.setDateOfRepairError("");
        }
        LocalDate l1 = LocalDate.parse(carDto.getDateOfRepair());
        LocalDate l2 = car.getServiceStartDate();
        if (l1.compareTo(l2) < 0) {
            carDto.setDateOfRepairError("Date of repair cannot be before date of service start");
        }
    }
}
