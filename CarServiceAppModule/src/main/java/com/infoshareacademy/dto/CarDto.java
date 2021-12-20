package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Category;

import javax.validation.constraints.Size;

public class CarDto {
    @Size(min = 5, max = 10)
    private String make;
    private final String licencePlate;
    private final Category category;
    private final Integer costOfService;
    private final Boolean repaired;
    private String description;
    private String dateOfRepair;

    public CarDto(String make, String licencePlate, Category category, Integer costOfService, Boolean repaired, String description, String dateOfRepair) {
        this.make = make;
        this.licencePlate = licencePlate;
        this.category = category;
        this.costOfService = costOfService;
        this.repaired = repaired;
        this.description = description;
        this.dateOfRepair = dateOfRepair;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfRepair() {
        return dateOfRepair;
    }

    public void setDateOfRepair(String dateOfRepair) {
        this.dateOfRepair = dateOfRepair;
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
