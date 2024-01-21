package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Book;

public class BookRepository {

    static Connection connection;

    public static Book saveBook(Book book) throws SQLException {

        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "INSERT INTO books (bookname, authorname) VALUES (?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.executeUpdate();

            return book;

        }
            return null;
    }
}
