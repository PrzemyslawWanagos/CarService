package com.infoshareacademy.domain;

public class Book {

    private final String author;
    private final String title;
    private final Category category;
    private final int pages;
    private final boolean forKids;

    public Book(String author, String title, Category category, int pages, boolean forKids) {
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

    @Override
    public String toString() {
        return "{" + author + ", " + title + " (" + pages + "str.)}";
    }
}
