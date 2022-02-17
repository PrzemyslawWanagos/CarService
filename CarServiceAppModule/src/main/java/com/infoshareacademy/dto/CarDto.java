package com.infoshareacademy.dto;

import com.infoshareacademy.domain.ProblemCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CarDto {

    @Size(min = 2, max = 50)
    private String brand;
    @Size(min = 2, max = 12)
    @Pattern(regexp = "^[A-Za-z0-9/-]+$", message = "Only alphanumeric characters and '-' is allowed in this field")
    private String licencePlate;
    private String description;
    private ProblemCategory problemCategory;
    @Min(50)
    @Max(10000)
    private Integer costOfService;
    private boolean repaired;
   @PastOrPresent(message="Date of Repair cannot be in the future")
    private LocalDate dateOfRepair;
    @PastOrPresent(message="Service Start Date cannot be in the future")
    private LocalDate serviceStartDate;
    private boolean duplicateLicencePlateError;
    private String dateOfRepairError;


    public CarDto() {
        duplicateLicencePlateError = false;
        dateOfRepairError = "";

    }


}
