package com.infoshareacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;


@SpringBootApplication
public class BookcaseApp {

    public static final String PROVIDERS_PATH = System.getProperty("user.dir") + "/Ex6/src/main/resources/public/books.json";

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BookcaseApp.class, args);
        Runtime rt = Runtime.getRuntime();
        rt.exec(new String[]{"cmd", "/c", "start http://localhost:8080/main"});
    }

}
