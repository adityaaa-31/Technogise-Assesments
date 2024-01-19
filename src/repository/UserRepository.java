import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import model.User;

public class UserRepository {


    static Connection connection;
    
    public static void create() throws SQLException {
        User user = new User();
        user.setUsername("user1");
        user.setId(UUID.randomUUID());

        connection = DatabaseConfig.makeConnection();
        if(connection != null){
            String query = "INSERT INTO user (id, username) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserId().toString());
            preparedStatement.setString(2, user.getUsername());
            
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

    }
}
