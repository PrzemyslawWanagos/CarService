package com.infoshareacademy.domain;

public enum Category {

    SEATS ("Crime, Thriller"),
    BRAKES("Fiction"),
    MAINTENANCE("Historical"),
    OTHER("Science Fiction"),
    DRIVE("Biography"),
    ENGINE("Romance");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
