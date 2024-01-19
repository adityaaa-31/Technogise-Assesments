package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import model.User;

public class UserRepository {
    
    static Connection connection;
    
    public static void create(User user) throws SQLException {
        connection = DatabaseConfig.makeConnection();
        
        if(connection != null){
            String query = "INSERT INTO user (id, username) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.executeUpdate();
            
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }
    
}
