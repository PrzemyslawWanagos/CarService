package com.infoshareacademy;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.IOException;

@SpringBootApplication
public class BookcaseApp {
    public static final String PROVIDERS_PATH = System.getProperty("user.dir") + "/BookCase/src/main/resources/public/books.json";
    static ConfigurableApplicationContext ctx;

    public static void main(String[] args) throws IOException {
        ctx = SpringApplication.run(BookcaseApp.class, args);
//        Runtime rt = Runtime.getRuntime();
//        rt.exec(new String[]{"cmd", "/c", "start http://localhost:8080/main"});
    }

    public static void exitApp() throws IOException {
//        Runtime rt = Runtime.getRuntime();
//        rt.exec(new String[]{"cmd", "/c", "exit http://localhost:8080/exit"});

        SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }


}
