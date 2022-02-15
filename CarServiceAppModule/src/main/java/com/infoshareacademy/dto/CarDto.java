package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Category;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CarDto {
    @Size(min = 2, max = 50)
    private String brand;
    @Size(min = 2, max = 12)
    @Pattern(regexp = "^[A-Za-z0-9/-]+$", message = "Only alphanumeric characters and '-' is allowed in this field")
    private String licencePlate;
    private String description;
    private Category category;
    @Min(50)
    @Max(10000)
    private Integer costOfService;
    private boolean repaired;
    private String dateOfRepair;
    private String serviceStartDate;
    private boolean duplicateLicencePlateError;
    private String dateOfRepairError;
    private boolean serviceStartDateError;

    public CarDto() {
        duplicateLicencePlateError = false;
        dateOfRepairError = "";
        serviceStartDateError = false;
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

    public boolean isDuplicateLicencePlateError() {
        return duplicateLicencePlateError;
    }

    public void setDuplicateLicencePlateError(boolean duplicateLicencePlateError) {
        this.duplicateLicencePlateError = duplicateLicencePlateError;
    }

    public String getDateOfRepairError() {
        return dateOfRepairError;
    }

    public void setDateOfRepairError(String dateOfRepairError) {
        this.dateOfRepairError = dateOfRepairError;
    }

    public boolean isServiceStartDateError() {
        return serviceStartDateError;
    }

    public void setServiceStartDateError(boolean serviceStartDateError) {
        this.serviceStartDateError = serviceStartDateError;
    }
}
