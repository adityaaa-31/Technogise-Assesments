package controller;

import java.util.Scanner;

import model.User;
import view.LibraryView;
import model.Book;
import model.Library;

public class LibraryController {
    UserController userController;
    BookController bookController;
    public Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    String username;

    public void addBook(Book b) {
        library.books.add(b);
    }

    public void addUser(User user) {
        library.users.add(user);
    }

    // public void getAllBooks() {
    //     LibraryView.showAllBooks(library);
    // }
 
}