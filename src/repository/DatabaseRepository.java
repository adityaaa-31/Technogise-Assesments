package repository;

public class DatabaseRepository {

    public void getDB() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
}
