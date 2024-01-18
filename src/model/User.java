package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String username;
    UUID userId;

    public List<Book> borrowedBooks = new ArrayList<>();

    public User(String username) {
        this.username = username;
        this.userId = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}