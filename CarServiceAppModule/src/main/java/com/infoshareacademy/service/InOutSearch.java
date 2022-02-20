package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.infoshareacademy.domain.Car;
import com.infoshareacademy.domain.ProblemCategory;
import com.infoshareacademy.repository.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.infoshareacademy.CarServiceApp.*;

@Service
public class InOutSearch {
    private Cars cars;

    @Autowired
    public InOutSearch(Cars cars) {
        this.cars = cars;
    }

    public InOutSearch() {
    }

    public List<Car> returnListOfCarsToRepair(@NotNull Cars cars, String stringToFind) {
        Predicate<Car> isCarRepaired = c -> !c.isRepaired();
        Predicate<Car> licencePlateFilter = c -> c.getLicencePlate().toUpperCase(Locale.ROOT).contains(stringToFind.toUpperCase(Locale.ROOT));
        Predicate<Car> brandFilter = c -> c.getBrand().toUpperCase(Locale.ROOT).contains(stringToFind.toUpperCase(Locale.ROOT));
        Predicate<Car> descriptionFilter = c -> c.getDescription().toUpperCase(Locale.ROOT).contains(stringToFind.toUpperCase(Locale.ROOT));
        return cars.getCars()
                .stream()
                .filter(isCarRepaired)
                .filter(licencePlateFilter.or(brandFilter).or(descriptionFilter))
                .sorted(Comparator.comparing(Car::getServiceStartDate))
                .collect(Collectors.toList());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        try {
            cars.setCars(readCarService().getCars());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static @Nullable
    Cars readCarService() throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
        Cars carsFromFile;
        File inputFile = new File(PATH_TO_FULL_LIST_OF_CARS);
        if (inputFile.length() == 0) {
            exception = "zero length input";
            return null;
        }
        carsFromFile = mapper.readValue(inputFile, new TypeReference<>() {
        });
        return carsFromFile;
    }

    public void saveCarService(Cars cars) throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PATH_TO_FULL_LIST_OF_CARS), cars);
    }

    public void saveRepairedCarList(Cars cars, LocalDate dateOfRepair) throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
        List<Car> listOfRepairedCars = returnListOfRepairedCars(cars, dateOfRepair);
        File carsRepairedToday = new File(PATH_TO_FOLDER_WITH_REPAIRED_CARS, dateOfRepair.toString() + ".json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(carsRepairedToday, listOfRepairedCars);
    }

    public Car FindByLicencePlate(@NotNull Cars cars, String LicencePlate) {

        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c -> Objects.nonNull(c.getLicencePlate()))
                .filter(c -> c.getLicencePlate().equals(LicencePlate))
                .filter(c -> Objects.isNull(c.getDateOfRepair()))
                .collect(Collectors.toList());
        if (toReturn.size() > 0) {
            return toReturn.get(0);
        } else {
            return null;
        }
    }

    public List<Car> returnListOfRepairedCars(@NotNull Cars cars, LocalDate dateOfRepair) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c -> Objects.nonNull(c.getDateOfRepair()))
                .filter(c -> c.getDateOfRepair().equals(dateOfRepair))
                .collect(Collectors.toList());
        return toReturn;
    }

    public List<Car> returnListOfRepairedCars(@NotNull Cars cars) {

        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c -> Objects.nonNull(c.isRepaired()))
                .filter(Car::isRepaired)
                .collect(Collectors.toList());
        if (toReturn.size() > 1) {
            toReturn = toReturn
                    .stream()
                    .sorted((c1, c2) -> c2.getDateOfRepair().compareTo(c1.getDateOfRepair()))
                    .collect(Collectors.toList());
        }
        return toReturn;
    }

    public List<Car> returnListCarsToRepair(@NotNull Cars cars) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c -> Objects.nonNull(c.isRepaired()))
                .filter(c -> !c.isRepaired())
                .sorted(Comparator.comparing(Car::getServiceStartDate))
                .collect(Collectors.toList());
        return toReturn;
    }
    public List<ProblemCategory> getCategories() {
        return Arrays.asList(ProblemCategory.values());
    }


}
