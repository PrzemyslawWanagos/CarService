package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCarToCarService(Car car) {
        cars.add(car);
    }

}
