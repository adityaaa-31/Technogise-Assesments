package controller;

import java.util.List;
import java.util.Scanner;
import model.User;
import model.Book;
import model.Library;

class LibraryController {
    UserController userController;
    BookController bookController;
    Library library;

    
    public LibraryController(Library library) {
        this.library = library;
    }

    public void addBook(Book b) {
        library.books.add(b);
    }

    public void addUser(User user) {
        library.users.add(user);
    }

    public List<Book> getBooks() {

        if (library.books.isEmpty()) {
            System.out.println("Library is Empty");
        }

        return library.books;
    }

    public Book getBook(String bookName) {

        for (Book book : library.books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public User getUser(String userName) {

        for (User user : library.users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public Book issueBook(User user, Book book) {

        if (book == null || user == null)
            return null;

        if (userController.canBorrow() && bookController.isBookAvailable(book)) {
            return book;
        }

        return null;
    }

    public void showUserBooks(String username) {
        for (User user : library.users) {
            if (user.getUsername().equals(username)) {
                List<Book> books = userController.getUserBooks();
                for (int i = 0; i < books.size(); i++) {
                    System.out.println("Books Borrowed " + books.get(i).getBookName());
                }
            }

        }
    }

}