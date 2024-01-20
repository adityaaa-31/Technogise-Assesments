package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import model.Book;
import model.Library;
import model.User;
import service.*;
import view.LibraryView;
import model.*;

public class UserController {

    User user;

    public User createUser(String usernname) {
        User user = new User();
        user.setUsername(usernname);

        UserService.createUser(user);
        return user;
    }

    public static void viewBooks() throws SQLException {

        List<Book> books = UserService.viewBooks();
        LibraryView.showAllBooks(books);

    }
}
