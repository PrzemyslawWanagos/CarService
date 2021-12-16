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
        books.add(new Car("Hanya Yanagihara", "Male zycie", Category.LITERATURA_PIEKNA, 816, false));
        books.add(new Car("Maja Lunde", "Historia Pszczol", Category.LITERATURA_PIEKNA, 514, false));
        books.add(new Car("Leonie Swann", "Kroczac w ciemnosci", Category.LITERATURA_PIEKNA, 424, false));
        books.add(new Car("George R.R. Martin", "Gra o tron", Category.FANTASTYKA_SCIENCE_FICTION, 999, false));
        books.add(new Car("J. R. R. Tolkien", "Hobbit", Category.FANTASTYKA_SCIENCE_FICTION, 315, false));
        books.add(new Car("Simon Beckett", "Chemia smierci", Category.KRYMINAL_SENSACJA_THRILLER, 352, false));
        books.add(new Car("Marc Elsberg", "Blackout", Category.KRYMINAL_SENSACJA_THRILLER, 784, false));
        books.add(new Car("Jozef Ignacy Kraszewski", "Stara basn", Category.HISTORYCZNA, 304, false));
        books.add(new Car("J. K. Rowling", "Harry Potter i Kamien Filozoficzny", Category.FANTASTYKA_SCIENCE_FICTION, 328, true));
        books.add(new Car("Antoine de Saint-Exupery", "Maly Ksiaze", Category.LITERATURA_PIEKNA, 112, true));
        books.add(new Car("Jojo Moyes", "Zanim się pojawiles", Category.OBYCZAJOWA_ROMANS, 382, false));
        books.add(new Car("Elizabeth Gilbert", "Jedz, modl sie, kochaj", Category.PUBLICYSTYKA_BIOGRAFIA, 490, false));
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
