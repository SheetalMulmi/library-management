package org.example;

import org.example.Models.Book;
import org.example.Models.Booklist;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Booklist bookl = new Booklist();
        bookl.createTable();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(bookl);
                    break;
                case 2:
                    displayBooks(bookl.getAllBooks());
                    break;
                case 3:
                    System.out.println("Exiting the Library Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System Menu:");
        System.out.println("1. Add a Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook(Booklist bookl) {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author: ");
        String author = scanner.nextLine();

        System.out.print("Enter the publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setYear(year);

        bookl.addBook(newBook);
        System.out.println("Book added successfully!");
    }



    private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in Library:");
            System.out.println("ID\tTitle\tAuthor\tYear");

            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
