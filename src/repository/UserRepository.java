package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import model.Book;
import model.User;

public class UserRepository {

    static Connection connection;

    public static User create(User user) throws SQLException {
        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        return user;
    }

    public static void login(User user) throws SQLException {
        connection = DatabaseConfig.makeConnection();

        if (connection != null) {
            String query = "select * from users where password = ?";

            PreparedStatement loginStatement = connection.prepareStatement(query);
            loginStatement.setString(1, user.getPassword());

            ResultSet resultSet = loginStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(user.getUsername() + " Logged in");
            } else {
                System.out.println("Invalid credentials");
            }

        } else {
            System.out.println("Something went wrong!");
        }
        // return user;
    }

    public static List<Book> getUserBooks(User user) {
        return user.borrowedBooks;
    }

}
