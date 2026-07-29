# Sistema de Biblioteca (Java)
Ejercicio de consolidación de fundamentos de Java: POO, colecciones, manejo de fechas y excepciones personalizadas. Simula un sistema básico de préstamo de libros por consola.


## Objetivo
Practicar en un solo flujo integrado:
- Programación orientada a objetos (clases, encapsulamiento, composición)
- Colecciones (`Map`, `List`)
- Manejo de fechas con `java.time.LocalDate`
- Excepciones personalizadas (`RuntimeException`)
- Entrada de datos por consola con `Scanner`

## Estructura del proyecto
\```
src/main/java/com/javier/biblioteca/
├── Book.java
├── User.java
├── Loan.java
├── Library.java
├── Main.java
└── (excepciones personalizadas)
    ├── BookAlreadyExistsException.java
    ├── UserAlreadyExistsException.java
    ├── BookNotFoundException.java
    ├── UserNotFoundException.java
    ├── BookNotAvailableException.java
    ├── BookAlreadyBorrowedException.java
    ├── BookNotBorrowedException.java
    ├── UserLimitExceededException.java
    └── LoanNotFoundException.java
\```

## Clases principales
**`Book`** — Representa un libro (`title`, `author`, `isbn`, `available`). Datos inmutables salvo la disponibilidad.
**`User`** — Representa un usuario de la biblioteca. Controla su propia lista de libros prestados (`borrowedBooks`), con un límite máximo de 3 libros simultáneos.
**`Loan`** — Representa un préstamo. Calcula automáticamente `loanDate` y `dueDate` (14 días de plazo) al crearse, y registra `returnDate` al devolverse.
**`Library`** — Clase orquestadora. Administra libros y usuarios registrados (`Map`) y préstamos activos (`List`), coordinando las validaciones entre `Book`, `User` y `Loan`.
**`Main`** — Menú interactivo por consola para probar el sistema.

## Funcionalidades
1. Agregar libro
2. Registrar usuario
3. Prestar libro
4. Devolver libro
5. Salir

## Reglas de negocio
- Un libro no puede prestarse si ya está prestado.
- Un usuario no puede tener más de 3 libros prestados a la vez.
- Un usuario no puede pedir el mismo libro dos veces.
- El plazo de préstamo es de 14 días desde la fecha del préstamo.
- No se puede devolver un libro que no fue prestado por ese usuario.

## Cómo ejecutar
\```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.javier.biblioteca.Main"
\```

O directamente desde IntelliJ, ejecutando la clase `Main`.

## Posibles mejoras futuras
- Listar libros disponibles y préstamos activos desde el menú
- Persistencia de datos (archivos o base de datos)
- Cálculo de días de atraso y multas
- Tests unitarios con JUnit

---
*Proyecto de práctica realizado como paso previo a Spring Boot.*
