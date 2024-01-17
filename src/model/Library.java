package model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books = new ArrayList<>();
    public List<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getBooks() {

        if (books.isEmpty()) {
            System.out.println("Library is Empty");
        }

        return books;
    }

    public Book getBook(String bookName) {

        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public User getUser(String userName) {

        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public Book issueBook(String username, String bookname) {
        User user = getUser(username);
        Book book = getBook(bookname);

        if (book == null || user == null)
            return null;

        if (user.canBorrow() && book.isBookAvailable()) {
            return book;
        }

        return null;
    }

    public void showUserBooks(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                List<Book> books = user.getUserBooks();
                for (int i = 0; i < books.size(); i++) {
                    System.out.println("Books Borrowed " + books.get(i).getBookName());
                }
            }

        }
    }

}