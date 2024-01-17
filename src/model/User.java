package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;

    public List<Book> borrowedBooks = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}