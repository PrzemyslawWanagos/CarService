package com.infoshareacademy.domain;

public class Book {

    private String author;
    private String title;
    private Category category;
    private int pages;
    private boolean forKids;

    public Book() {}

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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isForKids() {
        return forKids;
    }

    public void setForKids(boolean forKids) {
        this.forKids = forKids;
    }

    @Override
    public String toString() {
        return author + ", " + title + " (" + pages + "str.), category: " + category.getCategoryName() + ", " + ((forKids) ? "for kids" : "definitely not for kids");
    }

}
