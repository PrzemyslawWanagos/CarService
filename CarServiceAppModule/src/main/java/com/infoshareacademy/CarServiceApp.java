package com.infoshareacademy;

//import org.springframework.boot.ExitCodeGenerator;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

import static com.infoshareacademy.Utils.findFile;

@SpringBootApplication
public class CarServiceApp {

    public static final String PATH_TO_FULL_LIST_OF_CARS = findFile(System.getProperty("user.dir"), "cars.json").getAbsolutePath();
    static ConfigurableApplicationContext ctx;

    public static void main(String[] args) throws IOException {
        ctx = SpringApplication.run(CarServiceApp.class, args);
//        Runtime rt = Runtime.getRuntime();
//        rt.exec(new String[]{"cmd", "/c", "start http://localhost:8080/main"});
    }




}
