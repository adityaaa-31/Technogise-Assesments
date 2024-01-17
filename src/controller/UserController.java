package controller;

import java.util.List;

import model.Book;
import model.Library;
import model.User;

public class UserController {
    User user;
    public UserController(User user) {
        this.user = user;
    }

    boolean canBorrow() {
        if (user.borrowedBooks.size() >= 2) {
            return false;
        }

        return true;
    }

    public boolean borrowBook(Library library, String bookname) {
        Book book = library.issueBook(user.getUsername(), bookname);

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
