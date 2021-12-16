package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.infoshareacademy.Utils.listToString;

@Repository
public class Cars {

    private List<Car> cars;

    public Cars() {}



    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return listToString(cars, true);
    }

    public void addBookToBookcase(Car car) {
        cars.add(car);
    }

}
