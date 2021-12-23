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
import java.util.stream.*;
import java.util.stream.Collectors;

import static com.infoshareacademy.CarServiceApp.PATH_TO_FULL_LIST_OF_CARS;

@Service
public class Services {

    public Services() {

    }
    public List<Car> returnListOfCarsToRepair(Cars cars, String licencePlate) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c ->c.getLicencePlate().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT))&&!(c.isRepaired()))
                .collect(Collectors.toList());
//        List <Car> toReturn = new ArrayList<>();
//        try {
//        for (Car car : cars.getCars()) {
//            if (car.getLicencePlate().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT))
//            &&!(car.isRepaired())) {
//                toReturn.add(car);
//            }
//        }
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
        return toReturn;
    }

    public static Cars readCarService() {
        ObjectMapper mapper = new ObjectMapper();
        Cars CarsFromFile = new Cars();
        try {
            CarsFromFile = mapper.readValue(new File(PATH_TO_FULL_LIST_OF_CARS), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return CarsFromFile;
    }

    public void saveCarService(Cars cars) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PATH_TO_FULL_LIST_OF_CARS), cars);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public Integer FindByLicencePlate(Cars cars, String LicencePlate) {
        List <Car> toReturn = new ArrayList<>();
        int i=0;
        try {
            for (i = 0; i < cars.getCars().size(); i++) {
                if (cars.getCars().get(i).getLicencePlate().equals(LicencePlate)) {
                   break;
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return i;

    }

    public void fromDtoToEntity(CarDto carDto, Car car) {
        car.setMake(carDto.getMake());
        car.setLicencePlate(carDto.getLicencePlate());
        car.setDescription(carDto.getDescription());
        car.setCategory(carDto.getCategory());
    }

    public void fromEntityToDto(Car car, CarDto carDto) {
        carDto.setMake(car.getMake());
        carDto.setLicencePlate(car.getLicencePlate());
        carDto.setDescription(car.getDescription());
        carDto.setCategory(car.getCategory());
        carDto.setCostOfService(car.getCostOfService());
        carDto.setRepaired(car.isRepaired());
        //carDto.setDateOfRepair(car.getDateOfRepair());
    }
}
