package controller;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Library;
import model.User;

public class UserController {
    User user;
    static Scanner scanner = new Scanner(System.in);

    boolean canBorrow() {
        if (user.borrowedBooks.size() >= 2) {
            return false;
        }

        return true;
    }

    public String getUsername() {
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        return username;
    }

    public String getBookName() {
        System.out.println("Enter the book you want to borrow");
        // String bookname = scanner.nextLine();

        // return bookname;
        return scanner.nextLine();
    }

    public boolean borrowBook(Library library) {

        
        // Book book = libraryController.issueBook(username, bookname);

        // if (book != null) {
        // user.borrowedBooks.add(book);
        // return true;
        // }

        System.out.println(getUsername());
        System.out.println(getBookName());

        return false;
    }

    public List<Book> getUserBooks() {
        return user.borrowedBooks;
    }
}
