package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.infoshareacademy.Utils.listToString;

@Repository
public class Cars {

    private List<Car> cars;

    public Cars() {
        cars=new ArrayList<>();
    }



    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }



    public void addCarToCarService(Car car) {
        cars.add(car);
    }

}
