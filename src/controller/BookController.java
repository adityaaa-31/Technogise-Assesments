package controller;

import model.Book;

public class BookController {

    boolean isBookAvailable(Book book) {
        if (book.getNoOfCopies() == 0) {
            return false;
        }

        return true;
    }
}