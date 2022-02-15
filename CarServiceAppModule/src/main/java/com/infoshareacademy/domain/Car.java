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
    private ProblemCategory problemCategory;
    private int costOfService;
    private boolean repaired;
    private String description;
    private LocalDate dateOfRepair;
    private LocalDate serviceStartDate;
}
