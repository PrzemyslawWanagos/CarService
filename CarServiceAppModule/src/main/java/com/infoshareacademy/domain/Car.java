package com.infoshareacademy.domain;

public class Car {

    public String make;
    private String licencePlate;
    private Category category;
    private int pages;
    private boolean repaired;

    public Car() {}

    public Car(String make, String licencePlate, Category category, int pages, boolean repaired) {
        this.make = make;
        this.licencePlate = licencePlate;
        this.category = category;
        this.pages = pages;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    @Override
    public String toString() {
        return make + ", " + licencePlate + " (" + pages + "str.), category: " + category.getCategoryName() + ", " + ((repaired) ? "service completed" : "awaiting for service");
    }

}
