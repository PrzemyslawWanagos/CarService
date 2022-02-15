package com.infoshareacademy.mappers;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;

import javax.validation.constraints.NotNull;

public class CarVsCarDto {

    public static void fromDtoToEntity(@NotNull CarDto carDto, @NotNull Car car) {
        car.setBrand(carDto.getBrand());
        car.setLicencePlate(carDto.getLicencePlate());
        car.setDescription(carDto.getDescription());
        car.setProblemCategory(carDto.getProblemCategory());
        car.setServiceStartDate(carDto.getServiceStartDate());
    }

    public static void fromEntityToDto(@NotNull Car car, @NotNull CarDto carDto) {
        carDto.setBrand(car.getBrand());
        carDto.setLicencePlate(car.getLicencePlate());
        carDto.setDescription(car.getDescription());
        carDto.setProblemCategory(car.getProblemCategory());
        carDto.setCostOfService(car.getCostOfService());
        carDto.setRepaired(car.isRepaired());
        carDto.setServiceStartDate(car.getServiceStartDate());
    }
}
