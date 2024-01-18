package controller;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Library;
import model.User;

public class UserController {
    User user;
    Scanner scanner = new Scanner(System.in);
    String bookname;
    String username;

    boolean canBorrow() {
        if (user.borrowedBooks.size() >= 2) {
            return false;
        }

        return true;
    }

    void getBorrowData() {
        System.out.println("Enter the book you want to borrow");
        bookname = scanner.nextLine();

        System.out.println("Enter your username");
        username = scanner.nextLine();

    }

    public boolean borrowBook(Library library) {

        getBorrowData();
        // Book book = libraryController.issueBook(username, bookname);

        // if (book != null) {
        //     user.borrowedBooks.add(book);
        //     return true;
        // }

        System.out.println(username);
        System.out.println(bookname);

        return false;
    }

    public List<Book> getUserBooks() {
        return user.borrowedBooks;
    }
}
