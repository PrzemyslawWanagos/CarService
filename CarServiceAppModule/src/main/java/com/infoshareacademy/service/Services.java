package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.Car;
import com.infoshareacademy.dto.CarDto;
import com.infoshareacademy.repository.Cars;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.infoshareacademy.CarServiceApp.*;

@Service
public class Services {

    public Services() {
    }

    public List<Car> returnListOfCarsToRepair(@NotNull Cars cars, String licencePlate) {
        Predicate<Car> isCarRepaired = c->!c.isRepaired();
        Predicate<Car> licencePlateFilter = c-> c.getLicencePlate().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT));
        Predicate<Car> makeFilter = c-> c.getMake().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT));
        Predicate<Car> descriptionFilter = c-> c.getDescription().toUpperCase(Locale.ROOT).contains(licencePlate.toUpperCase(Locale.ROOT));


        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(isCarRepaired)
                .filter(licencePlateFilter.or(makeFilter).or(descriptionFilter))
                .sorted((c1, c2) -> c1.getServiceStartDate().compareTo(c2.getServiceStartDate()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public static @Nullable Cars readCarService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Cars CarsFromFile = new Cars();
        File inputFile = new File(PATH_TO_FULL_LIST_OF_CARS);
        if (inputFile.length() == 0) {
            exception = "zero length input";
            return null;
        }
        CarsFromFile = mapper.readValue(inputFile, new TypeReference<>() {
        });
        return CarsFromFile;
    }

    public void saveCarService(Cars cars) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PATH_TO_FULL_LIST_OF_CARS), cars);
    }

    public void saveRepairedCarList(Cars cars, String dateOfRepair) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Car> listOfRepairedCars = returnListOfRepairedCars(cars, dateOfRepair);
        File carsRepairedToday = new File(PATH_TO_FOLDER_WITH_REPAIRED_CARS, dateOfRepair + ".json");
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

    public List<Car> returnListOfRepairedCars(@NotNull Cars cars, String dateOfRepair) {
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
                .filter(c -> c.isRepaired() == true)
                .sorted((c1, c2) -> c2.getDateOfRepair().compareTo(c1.getDateOfRepair()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public List<Car> returnListCarsToRepair(@NotNull Cars cars) {
        List<Car> toReturn = cars.getCars()
                .stream()
                .filter(c -> Objects.nonNull(c.isRepaired()))
                .filter(c -> c.isRepaired() == false)
                .sorted((c1, c2) -> c1.getServiceStartDate().compareTo(c2.getServiceStartDate()))
                .collect(Collectors.toList());
        return toReturn;
    }

    public void fromDtoToEntity(@NotNull CarDto carDto, @NotNull Car car) {
        car.setMake(carDto.getMake());
        car.setLicencePlate(carDto.getLicencePlate());
        car.setDescription(carDto.getDescription());
        car.setCategory(carDto.getCategory());
        car.setServiceStartDate(carDto.getServiceStartDate());
    }

    public void fromEntityToDto(@NotNull Car car, @NotNull CarDto carDto) {
        carDto.setMake(car.getMake());
        carDto.setLicencePlate(car.getLicencePlate());
        carDto.setDescription(car.getDescription());
        carDto.setCategory(car.getCategory());
        carDto.setCostOfService(car.getCostOfService());
        carDto.setRepaired(car.isRepaired());
        carDto.setServiceStartDate(car.getServiceStartDate());
    }
}
