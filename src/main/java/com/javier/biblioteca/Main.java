package com.javier.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Library library = new Library();
        boolean running =true;

        while(running){
            System.out.println("=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    teclado.nextLine();
                    System.out.print("Ingrese el título: ");
                    String title = teclado.nextLine();

                    System.out.print("Ingrese el autor: ");
                    String author = teclado.nextLine();

                    System.out.print("Ingrese el ISBN: ");
                    String isbn = teclado.nextLine();

                    Book book = new Book(title,author,isbn);
                    try{
                        library.addBook(book);
                        System.out.println("Libro agregado exitosamente");
                    }catch (BookAlreadyExistsException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    teclado.nextLine();
                    System.out.println("Ingrese el nombre");
                    String name = teclado.nextLine();

                    System.out.println("Ingrese el ID:");
                    int id = Integer.parseInt(teclado.nextLine());

                    User user = new User(name,id);

                    try{
                        library.registerUser(user);
                        System.out.println("Usuario creado con exito");
                    } catch (UserAlreadyExistsException e){
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;

                case 3:
                    teclado.nextLine();
                    System.out.println("Ingrese el ISBN del libro");
                    String isbnToBorrow = teclado.nextLine();

                    System.out.println("Ingrese el id del usuario:");
                    int userIdToBorrow = Integer.parseInt(teclado.nextLine());

                    try{
                        library.borrowBook(isbnToBorrow,userIdToBorrow);
                        System.out.println("Libro prestado exitosamente");
                    } catch (BookNotFoundException | UserNotFoundException | BookNotAvailableException| UserLimitExceededException e){
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;

                case 4:
                    teclado.nextLine();
                    System.out.println("Ingrese el ISBN del libro");
                    String isbnToReturn = teclado.nextLine();

                    System.out.println("Ingrese el id del usuario:");
                    int userIdToReturn = Integer.parseInt(teclado.nextLine());

                    try{
                        library.returnBook(isbnToReturn,userIdToReturn);
                        System.out.println("libro devuelto exitosamente");
                    } catch (BookNotFoundException | UserNotFoundException | LoanNotFoundException e){
                        System.out.println("Error: "+ e.getMessage());
                    }

                    break;
                case 0:
                    running = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }
    }
}
