package com.infoshareacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.Book;
import com.infoshareacademy.repository.Books;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import static com.infoshareacademy.Utils.listToString;

@Service
public class Services {

    public Services() {
    }

    public String getRandomBook(Books books) {
        Random random = new Random();
        int bookPosition = random.nextInt(books.getBooks().size());
        return books.getBooks().get(bookPosition).toString();
    }

    public String browseThroughBooks(Books books, String title) {
        List<Book> toReturn = new ArrayList<>();
        for (Book book : books.getBooks()) {
            if (book.getTitle().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT))) {
                toReturn.add(book);
            }
        }
        if (toReturn.size() > 0) {
            return listToString(toReturn, true);
        } else {
            return "There are no books meeting your title criteria";
        }
    }

    public void saveBookCase(Books books) {
        String PROVIDERS_PATH = System.getProperty("user.dir") + "/Ex6/src/main/resources/public/books.json";
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROVIDERS_PATH), books);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
