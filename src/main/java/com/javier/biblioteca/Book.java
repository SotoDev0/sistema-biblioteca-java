package com.javier.biblioteca;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available=true;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    //Getter
    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    //Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}
