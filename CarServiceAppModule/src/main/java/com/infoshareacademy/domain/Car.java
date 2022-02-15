package com.infoshareacademy.domain;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String licencePlate;
    private Category category;
    private int costOfService;
    private boolean repaired;
    private String description;
    private String dateOfRepair;
    private LocalDate serviceStartDate;

    public Car() {
    }

    public Car(String brand, String licencePlate, Category category, int costOfService, boolean repaired, String description, String dateOfRepair, LocalDate serviceStartDate) {
        this.brand = brand;
        this.licencePlate = licencePlate;
        this.category = category;
        this.costOfService = costOfService;
        this.repaired = repaired;
        this.description = description;
        this.dateOfRepair = dateOfRepair;
        this.serviceStartDate = serviceStartDate;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public int getCostOfService() {
        return costOfService;
    }

    public void setCostOfService(int costOfService) {
        this.costOfService = costOfService;
    }

    public boolean isRepaired() {
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

    public LocalDate getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(LocalDate serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

}
