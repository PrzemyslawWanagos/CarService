package com.infoshareacademy.domain;

public class Car {

    public String make;
    private String licencePlate;
    private Category category;
    private int costOfService;
    private boolean repaired;

    public Car() {}

    public Car(String make, String licencePlate, Category category, int costOfService, boolean repaired) {
        this.make = make;
        this.licencePlate = licencePlate;
        this.category = category;
        this.costOfService = costOfService;
        this.repaired = repaired;
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

    @Override
    public String toString() {
        return make + ", " + licencePlate + " (" + costOfService + "str.), category: " + category.getCategoryName() + ", " + ((repaired) ? "service completed" : "awaiting for service");
    }

}
