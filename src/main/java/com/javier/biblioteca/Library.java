package com.javier.biblioteca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<Integer, User>users;
    private List<Loan> activeLoans;

    public Library() {
        this.activeLoans = new ArrayList<>();
        this.books = new HashMap<>();
        this.users = new HashMap<>();
    }

    //Metodos
    public void addBook(Book book){
        if(books.containsKey(book.getIsbn())){
            throw new BookAlreadyExistsException("El libro ya esta registrado en la biblioteca");
        }
        books.put(book.getIsbn(),book);
    }

    public void registerUser(User user){
        if(users.containsKey(user.getId())){
            throw new UserAlreadyExistsException("El usuario ya esta registrado");
        }
        users.put(user.getId(),user);
    }

    public void borrowBook(String isbn, int userId){
        if(!books.containsKey(isbn)){
            throw new BookNotFoundException("No existe un libro con ese isbn");
        }

        if(!users.containsKey(userId)){
            throw new UserNotFoundException("No existe el usuario");
        }

        if (!books.get(isbn).isAvailable()){
            throw new BookNotAvailableException("El libro no esta disponible actualmente");
        }

        Book book = books.get(isbn);
        User user = users.get(userId);

        //Marcar no dispónible
        book.setAvailable(false);

        //Agregar el libro al usuario
        user.addBorrowedBook(book);

        // crear Loan
        Loan loan = new Loan(book,user);

        //Guardar en activeLoans
        activeLoans.add(loan);
    }

    public void returnBook(String isbn, int userId){
        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException("No existe un libro con ese isbn");
        }
        if (!users.containsKey(userId)) {
            throw new UserNotFoundException("No existe el usuario");
        }

        Loan loanToReturn = null;
        for(Loan loan : activeLoans){
            if(loan.getBook().getIsbn().equals(isbn) && loan.getUser().getId() == userId){
                loanToReturn = loan;
                break;
            }
        }

        if(loanToReturn == null){
            throw new LoanNotFoundException("No se encontró un prestamo activo con ese libro y usuario");
        }

        loanToReturn.getBook().setAvailable(true);
        loanToReturn.getUser().removeBorrowedBook( loanToReturn.getBook());
        loanToReturn.markAsReturned();
        activeLoans.remove(loanToReturn);
    }

}
