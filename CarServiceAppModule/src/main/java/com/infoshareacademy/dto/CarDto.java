package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Category;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CarDto {
    @Size(min = 2, max = 50)
    private String make;
    @Size(min = 2, max = 12)
    private  String licencePlate;
    private String description;
    private  Category category;
    @Min(50)
    @Max(10000)
    private  Integer costOfService;
    private  boolean repaired;

    private String dateOfRepair;
    private String serviceStartDate;


    public CarDto() {
       // this.category=Category.OTHER;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public String getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCostOfService() {
        return costOfService;
    }

    public void setCostOfService(Integer costOfService) {
        this.costOfService = costOfService;
    }

    public boolean getRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
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
