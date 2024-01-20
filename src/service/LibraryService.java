package service;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import repository.LibraryRepository;

public class LibraryService {

    public static List<Book> getAllBooks() throws SQLException {

        List<Book> books = LibraryRepository.getAllBooks();
        return books;
        
    }

    // public Book getBookByName(String bookName) {

    //     for (Book book : library.books) {
    //         if (book.getBookName().equals(bookName)) {
    //             return book;
    //         }
    //     }
    //     return null;
    // }

    // public Book issueBook(String username, String bookname) {

    //     Book book = getBookByName(bookname);

    //     if (userController.canBorrow()) {
    //         return book;
    //     }

    //     return null;
    // }
}
