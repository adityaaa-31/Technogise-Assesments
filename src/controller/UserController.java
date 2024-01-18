package controller;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Library;
import model.User;

public class UserController {
    User user;
    static Scanner scanner = new Scanner(System.in);

    public boolean canBorrow() {
        return user.borrowedBooks.size() <= 2;
    }

    public String getUsername() {
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        return username;
    }

    public String getBookName() {
        System.out.println("Enter the book you want to borrow");
        String bookname = scanner.nextLine();
        return bookname;
    }

    public boolean borrowBook(Library library, LibraryController libraryController) {
        Book book = libraryController.issueBook(getUsername(), getBookName());

        if (book != null) {
            user.borrowedBooks.add(book);
            return true;
        }

        return false;
    }

    public List<Book> getUserBooks() {
        return user.borrowedBooks;
    }
}
