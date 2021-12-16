package com.infoshareacademy.domain;

public enum Category {

    SEATS ("Problems with seats"),
    BRAKES("Problems with brakes"),
    MAINTENANCE("General maintenance"),
    OTHER("Science Problems with brakes"),
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
