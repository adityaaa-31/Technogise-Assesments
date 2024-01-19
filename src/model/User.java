package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String username;
    private UUID id;

    public List<Book> borrowedBooks = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public UUID getUserId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}