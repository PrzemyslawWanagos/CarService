package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.Car;
import com.infoshareacademy.repository.Cars;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

//import static com.infoshareacademy.CarServiceApp.PROVIDERS_PATH;
import static com.infoshareacademy.CarServiceApp.PROVIDERS_PATH;
import static com.infoshareacademy.Utils.listToString;

@Service
public class Services {

    public Services() {}

    public static Cars readCarService() {
        ObjectMapper mapper = new ObjectMapper();
        Cars CarsFromFile = new Cars();
//
//        File file=findFile(System.getProperty("user.dir"), "cars.json");
//        //File file = Paths.get(".", "CarServiceAppModule", "cars.json").normalize().toFile();
//        String test = file.getAbsolutePath();
//        System.out.println(test);
        try {
            CarsFromFile = mapper.readValue(new File(PROVIDERS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CarsFromFile;
    }

    public String getRandomCar(Cars cars) {
        Random random = new Random();
        int CarPosition = random.nextInt(cars.getCars().size());
        return cars.getCars().get(CarPosition).toString();
    }

    public String browseThroughCars(Cars cars, String title) {
        List<Car> toReturn = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getLicencePlate().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT))) {
                toReturn.add(car);
            }
        }
        if (toReturn.size() > 0) {
            return listToString(toReturn, true);
        } else {
            return "There are no Cars meeting your title criteria";
        }
    }

    public List<Car> returnListOfCars(Cars cars, String title) {
        List <Car> toReturn = new ArrayList<>();
        try {
            for (Car car : cars.getCars()) {
                if (car.getLicencePlate().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT))) {
                    toReturn.add(car);
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
            return toReturn;

    }

    public void saveCarService(Cars cars) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROVIDERS_PATH), cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer findIFForTitle(Cars cars, String title) {
        List <Car> toReturn = new ArrayList<>();
        int i=0;
        try {
            for (i = 0; i < cars.getCars().size(); i++) {
                if (cars.getCars().get(i).getLicencePlate().equals(title)) {
                   break;
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return i;

    }

}
