package com.javier.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    //Add book
     public void addBorrowedBook(Book book){
            if(borrowedBooks.size() >= 3){
               throw new UserLimitExceededException("El usuario ya alcanzó el límite de 3 libros prestados");
            }
            if (borrowedBooks.contains(book)){
                throw new BookAlreadyBorrowedException("El usuario ya tiene este libro prestado");
            }
            borrowedBooks.add(book);
    }

    //Delete book
    public void removeBorrowedBook(Book book){
        boolean wasRemoved = borrowedBooks.remove(book);
        if(!wasRemoved){
            throw new BookNotBorrowedException("El usuario no contiene el libro para ser eliminado");
        }
    }




    @Override
    public String toString() {
        return "User{" +
                "borrowedBooks=" + borrowedBooks +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
