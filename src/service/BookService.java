package service;

import java.sql.SQLException;

import model.Book;
import repository.BookRepository;

public class BookService {

    public static Book saveBook(Book book) throws SQLException {
        return BookRepository.saveBook(book);
    }
}
