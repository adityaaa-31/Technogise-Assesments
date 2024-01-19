package controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import model.Book;
import model.Library;
import model.User;
import service.*;
import model.*;

public class UserController {

    User user;

    public User createUser(String usernname) {
        User user = new User();
        user.setUsername(usernname);
        user.setId(UUID.randomUUID());

        UserService.createUser(user);
        return user;
    }

    public boolean canBorrow() {
        return user.borrowedBooks.size() <= 2;
    }


    public boolean borrowBook(String username, String bookname, Library library, LibraryController libraryController) {
        Book book = libraryController.issueBook(username, bookname);

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
