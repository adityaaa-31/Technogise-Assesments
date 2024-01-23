package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Book;
import model.User;

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

    public static Book getBookByName(String bookname) throws SQLException {

        connection = DatabaseConfig.makeConnection();
        Book book = new Book();

        if (connection != null) {
            String query = "SELECT * from book WHERE bookaname = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                book.setBookName(resultSet.getString("bookname"));
                book.setAuthorName(resultSet.getString("authorname"));

            }
        }
        return book;
    }

    public static Book saveBook(Book book) throws SQLException {

        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "INSERT INTO books (bookname, authorname, id) VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setString(3, UUID.randomUUID().toString());
            preparedStatement.executeUpdate();

        }
        return book;
    }

    public static Book issueBook(User user, Book book) {
        connection = DatabaseConfig.makeConnection();

        if (connection != null) {

        }
        return book;
    }
}
