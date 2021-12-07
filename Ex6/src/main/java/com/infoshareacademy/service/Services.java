package com.infoshareacademy.service;

import com.infoshareacademy.domain.Book;
import com.infoshareacademy.repository.Books;
import org.springframework.stereotype.Service;
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
}
