package model;

import java.util.UUID;

public class Book {
    private String bookName;
    private String authorName;
    private UUID bookId;

    public Book(String bookName, String authorName, int noOfCopies) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookId = UUID.randomUUID();
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}