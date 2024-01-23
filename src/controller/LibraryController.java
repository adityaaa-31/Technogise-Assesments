package controller;

import java.sql.SQLException;
import java.util.Scanner;

import model.User;
import service.LibraryService;
import view.LibraryView;
import model.Book;
import model.Library;

public class LibraryController {

    public void getAllBooks() {

    }

    public static Book saveBook(String bookname, String authorname) throws SQLException {
        Book book = new Book();
        book.setBookName(bookname);
        book.setAuthorName(authorname);
        return LibraryService.saveBook(book);
    }

}