package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Category;


public class BookDto {

    private final String author;
    private final String title;
    private final Category category;
    private final Integer pages;
    private final Boolean forKids;

    public BookDto(String author, String title, Category category, Integer pages, Boolean forKids) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.pages = pages;
        this.forKids = forKids;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public int getPages() {
        return pages;
    }

    public boolean isForKids() {
        return forKids;
    }


}
