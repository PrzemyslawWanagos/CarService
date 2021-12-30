package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.*;
import java.util.stream.Collectors;

import static com.infoshareacademy.CarServiceApp.*;

@Service
public class Services {

    public Services() {

    }
    public List<Car> returnListOfCarsToRepair(Cars cars, String licencePlate) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->c.getLicencePlate().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT))&&!(c.isRepaired()))
                .sorted((c1, c2)->c1.getServiceStartDate().compareTo(c2.getServiceStartDate()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public static Cars readCarService() {
        ObjectMapper mapper = new ObjectMapper();
        Cars CarsFromFile = new Cars();
        try {
            CarsFromFile = mapper.readValue(new File(PATH_TO_FULL_LIST_OF_CARS), new TypeReference<>() {
            });
        } catch (IOException e) {
            exception=e;
            System.out.println(e.toString());
        }
        return CarsFromFile;
    }

    public void saveCarService(Cars cars) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PATH_TO_FULL_LIST_OF_CARS), cars);
        } catch (IOException e) {
            exception=e;
            System.out.println(e.toString());
        }
    }

    public void saveRepairedCarList(Cars cars, String dateOfRepair) {
         List <Car> listOfRepairedCars = returnListOfRepairedCars(cars, dateOfRepair);

        ObjectMapper mapper = new ObjectMapper();
        try {
            File carsRepairedToday=new File(PATH_TO_FOLDER_WITH_REPAIRED_CARS,dateOfRepair+".json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(carsRepairedToday, listOfRepairedCars);
        } catch (IOException e) {
            exception=e;
            System.out.println(e.toString());
        }
    }

    public Car FindByLicencePlate(Cars cars, String LicencePlate) {

        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->Objects.nonNull(c.getLicencePlate()))
                .filter(c ->c.getLicencePlate().equals(LicencePlate))
                .filter(c->Objects.isNull(c.getDateOfRepair()))
                .collect(Collectors.toList());
        if (toReturn.size() > 0) {
            return toReturn.get(0);
        } else {
            return null;
        }

    }

    public List<Car> returnListOfRepairedCars(Cars cars, String dateOfRepair) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->Objects.nonNull(c.getDateOfRepair()))
                .filter(c ->c.getDateOfRepair().equals(dateOfRepair))
                .collect(Collectors.toList());
        return toReturn;
    }
    public List<Car> returnListOfRepairedCars(Cars cars) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->Objects.nonNull(c.isRepaired()))
                .filter(c ->c.isRepaired()==true)
                .sorted((c1, c2)->c2.getDateOfRepair().compareTo(c1.getDateOfRepair()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public List<Car> returnListCarsToRepair(Cars cars) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->Objects.nonNull(c.isRepaired()))
                .filter(c ->c.isRepaired()==false)
                .sorted((c1, c2)->c1.getServiceStartDate().compareTo(c2.getServiceStartDate()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public void fromDtoToEntity(CarDto carDto, Car car) {
        car.setMake(carDto.getMake());
        car.setLicencePlate(carDto.getLicencePlate());
        car.setDescription(carDto.getDescription());
        car.setCategory(carDto.getCategory());
        car.setServiceStartDate(carDto.getServiceStartDate());
    }

    public void fromEntityToDto(Car car, CarDto carDto) {
        carDto.setMake(car.getMake());
        carDto.setLicencePlate(car.getLicencePlate());
        carDto.setDescription(car.getDescription());
        carDto.setCategory(car.getCategory());
        carDto.setCostOfService(car.getCostOfService());
        carDto.setRepaired(car.isRepaired());
        carDto.setServiceStartDate(car.getServiceStartDate());
        //carDto.setDateOfRepair(car.getDateOfRepair());
    }
}
