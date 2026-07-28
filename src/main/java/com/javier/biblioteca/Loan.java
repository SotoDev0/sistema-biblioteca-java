package com.javier.biblioteca;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(14);
        this.returnDate = null;
    }

    //Getters
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    //Metodos
    public boolean isOverdue(){
        return returnDate==null  && LocalDate.now().isAfter(dueDate);
    }

    public void markAsReturned(){
        returnDate = LocalDate.now();
    }

}
