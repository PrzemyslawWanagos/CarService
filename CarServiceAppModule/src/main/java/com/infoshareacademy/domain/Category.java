package com.infoshareacademy.domain;

public enum Category {

    KRYMINAL_SENSACJA_THRILLER ("Crime, Thriller"),
    LITERATURA_PIEKNA("Fiction"),
    HISTORYCZNA("Historical"),
    FANTASTYKA_SCIENCE_FICTION("Science Fiction"),
    PUBLICYSTYKA_BIOGRAFIA("Biography"),
    OBYCZAJOWA_ROMANS("Romance");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
