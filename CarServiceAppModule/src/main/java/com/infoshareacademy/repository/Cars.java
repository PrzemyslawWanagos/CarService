package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Car;
import com.infoshareacademy.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.infoshareacademy.Utils.listToString;

@Repository
public class Cars {

    private List<Car> books;

    public Cars() {}

    private static List<Car> importBooks() {
        List<Car> books = new ArrayList<>();
        books.add(new Car("Hanya Yanagihara", "Male zycie", Category.BRAKES, 816, false));
        books.add(new Car("Maja Lunde", "Historia Pszczol", Category.BRAKES, 514, false));
        books.add(new Car("Leonie Swann", "Kroczac w ciemnosci", Category.BRAKES, 424, false));
        books.add(new Car("George R.R. Martin", "Gra o tron", Category.OTHER, 999, false));
        books.add(new Car("J. R. R. Tolkien", "Hobbit", Category.OTHER, 315, false));
        books.add(new Car("Simon Beckett", "Chemia smierci", Category.SEATS, 352, false));
        books.add(new Car("Marc Elsberg", "Blackout", Category.SEATS, 784, false));
        books.add(new Car("Jozef Ignacy Kraszewski", "Stara basn", Category.MAINTENANCE, 304, false));
        books.add(new Car("J. K. Rowling", "Harry Potter i Kamien Filozoficzny", Category.OTHER, 328, true));
        books.add(new Car("Antoine de Saint-Exupery", "Maly Ksiaze", Category.BRAKES, 112, true));
        books.add(new Car("Jojo Moyes", "Zanim się pojawiles", Category.ENGINE, 382, false));
        books.add(new Car("Elizabeth Gilbert", "Jedz, modl sie, kochaj", Category.DRIVE, 490, false));
        return books;
    }

    public List<Car> getBooks() {
        return books;
    }

    public void setBooks(List<Car> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return listToString(books, true);
    }

    public void addBookToBookcase(Car car) {
        books.add(car);
    }

}
