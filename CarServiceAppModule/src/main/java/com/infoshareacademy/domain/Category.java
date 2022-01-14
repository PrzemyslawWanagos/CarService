package com.infoshareacademy.domain;

public enum Category {

    SEATS("Problems with seats"),
    BRAKES("Problems with brakes"),
    MAINTENANCE("General maintenance"),
    OTHER("Other problems"),
    DRIVE("Problems with drive"),
    ENGINE("Problems with engine");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
