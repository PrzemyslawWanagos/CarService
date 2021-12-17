package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Category;

public class CarDto {

    private final String make;
    private final String licencePlate;
    private final Category category;
    private final Integer costOfService;
    private final Boolean repaired;

    public CarDto(String make, String licencePlate, Category category, Integer costOfService, Boolean repaired) {
        this.make = make;
        this.licencePlate = licencePlate;
        this.category = category;
        this.costOfService = costOfService;
        this.repaired = repaired;
    }

    public String getMake() {
        return make;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public Category getCategory() {
        return category;
    }

    public int getCostOfService() {
        return costOfService;
    }

    public boolean getRepaired() {
        return repaired;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "make='" + make + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", category=" + category +
                ", costOfService=" + costOfService +
                ", repaired=" + repaired +
                '}';
    }
}
