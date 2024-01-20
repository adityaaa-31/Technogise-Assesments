package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

import javax.naming.spi.DirStateFactory.Result;

public class LibraryRepository {

    static Connection connection;

    public static List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "SELECT * FROM books";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet bookResultSet = preparedStatement.executeQuery();

            while (bookResultSet.next()) {
                Book book = new Book();

                book.setBookName(bookResultSet.getString("bookname"));
                book.setAuthorName(bookResultSet.getString("authorname"));

                books.add(book);

            }

        }

        return books;
    }
}
