package com.infoshareacademy.rest;


import com.infoshareacademy.domain.Book;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.repository.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.infoshareacademy.Utils.listToString;
import static com.infoshareacademy.Utils.test;

//@org.springframework.web.bind.annotation.RestController
//@org.springframework.web.bind.annotation.RestController
@Controller
public class RestController {
    @Autowired
    Books books;

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/all-books")
    @ResponseBody
    public String getBookcase() {
        return listToString(books.getBooks(), true) + "<br> <br> <button onclick=\"window.location.href='http://localhost:8080/main';\">Main menu</button>";
    }

    @GetMapping("/book-for-today")
    @ResponseBody
    public String getBook() {
        Random random = new Random();

        Integer bookPosition = random.nextInt(books.getBooks().size());
        return books.getBooks().get(bookPosition).toString() + "<br> <br> <button onclick=\"window.location.href='http://localhost:8080/main';\">Main menu</button>";
    }

    @GetMapping("/book/{title}/search")
    @ResponseBody
    public String findBook(@PathVariable String title) {
        List<Book> toReturn = new ArrayList<>();       //                      @RequestParam(required = false, name = ""text"", defaultValue = "cool t-shirt") String name) {
        for (Book book : books.getBooks()) {
            if (book.getTitle().toUpperCase(Locale.ROOT).contains(title.toUpperCase(Locale.ROOT))) {
                toReturn.add(book);
            }
        }
        return listToString(toReturn, true) + "<br> <br> <button onclick=\"window.location.href='http://localhost:8080/main';\">Main menu</button>";
    }

    @GetMapping("book/search")
    @ResponseBody

    public void addCriteriaToFindBook() {
        try {
            test("mal");
        } catch (Exception e) {
            e.printStackTrace();
            //findBook(name);            /*String msg="Hello "+ name;
            //add a message to the model

            // return "viewpage";*/

        }
        //@ResponseBody
         //       String toReturn="";
        //return "Some String";
    }

//    @GetMapping("/hello")
//    @ResponseBody
    @RequestMapping("/hello")
    //read the provided form data
    public String display(@RequestParam("name") String name) {
        //URL url;
        String a = "http://localhost:8080/book/"+name+"/search";
        return "redirect:" + a;// + "<br> <br> <button onclick=\"window.location.href='http://localhost:8080/main';\">Main menu</button>";;
//        try {
//            Runtime rt = Runtime.getRuntime();
//            String a = "http://localhost:8080/book/"+name+"/search";
//            rt.exec("rundll32 url.dll,FileProtocolHandler "+a);
//
////            // get URL content
////            Desktop desktop = java.awt.Desktop.getDesktop();
////            String a = "http://localhost:8080/book/"+name+"/search";
////            URI oURL = new URI(a);
////            desktop.browse(oURL);
//////            URLConnection conn = url.openConnection();
//////            conn.connect();
////            int b=5;
//        } catch (Exception e) {
//            e.printStackTrace();
//            //findBook(name);            /*String msg="Hello "+ name;
//            //add a message to the model
//
//            // return "viewpage";*/
//
//        }
    }


}
