package controller;

import java.util.Scanner;
import model.User;
import model.Book;
import model.Library;
class LibraryController {
    
    public static void main(String[] args) {
        // Initialise the library
        Library library = new Library();

        Scanner sc = new Scanner(System.in);

        User user;
        String bookName;
        String username;
        int choice;

        library.addBook(new Book("Top Gear", "BBC", 3));
        library.addBook(new Book("Harry Potter", "JK Rowling", 4));

        library.addUser(new User("Aditya"));

        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. View Your Books");

        do {
            System.out.println("Enter a choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                   
                    for(Book book: library.getBooks()) {
                        System.out.println(book.getBookName());
                    }
                    break;

                case 2:
                    System.out.println("Enter the book you want to borrow");
                    sc.nextLine();
                    bookName = sc.nextLine();

                    System.out.println("Enter your username");
                    username = sc.nextLine();

                    user = library.getUser(username);
                    

                    if (user.borrowBook(library, bookName)) {
                        System.out.println("Book Borrowed");
                    } else {
                        System.out.println("Cannot Borrow Book");
                    }

                    break;

                case 3:
                    System.out.println("Enter your name");
                    sc.nextLine();
                    username = sc.nextLine();
                    library.showUserBooks(username);

                default:
                    break;
            }
        } while (choice != 4);

        sc.close();

    }
}