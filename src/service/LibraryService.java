package service;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import repository.BookRepository;
import repository.LibraryRepository;

public class LibraryService {

    public static List<Book> getAllBooks() throws SQLException {
        List<Book> books = LibraryRepository.getAllBooks();
        return books;
    }

    public Book getBookByName(String bookName) throws SQLException {
        Book book = LibraryRepository.getBookByName(bookName);
        return book;
    }

    public static Book saveBook(Book book) throws SQLException {
        return LibraryRepository.saveBook(book);
    }

    public Book issueBook(String username, String bookname) {

        try {
            Book book = getBookByName(bookname);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
