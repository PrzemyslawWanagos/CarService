package com.infoshareacademy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Car {

    private String brand;
    private String licencePlate;
    private Category category;
    private int costOfService;
    private boolean repaired;
    private String description;
    private LocalDate dateOfRepair;
    private LocalDate serviceStartDate;
}


//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getLicencePlate() {
//        return licencePlate;
//    }
//
//    public void setLicencePlate(String licencePlate) {
//        this.licencePlate = licencePlate;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public int getCostOfService() {
//        return costOfService;
//    }
//
//    public void setCostOfService(int costOfService) {
//        this.costOfService = costOfService;
//    }
//
//    public boolean isRepaired() {
//        return repaired;
//    }
//
//    public void setRepaired(boolean repaired) {
//        this.repaired = repaired;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDate getDateOfRepair() {
//        return dateOfRepair;
//    }
//
//    public void setDateOfRepair(LocalDate dateOfRepair) {
//        this.dateOfRepair = dateOfRepair;
//    }
//
//    public LocalDate getServiceStartDate() {
//        return serviceStartDate;
//    }
//
//    public void setServiceStartDate(LocalDate serviceStartDate) {
//        this.serviceStartDate = serviceStartDate;
//    }
//
//}
