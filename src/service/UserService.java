package service;

import java.sql.SQLException;
import java.util.List;

import controller.LibraryController;
import model.Book;
import model.Library;
import model.User;
import repository.UserRepository;

public class UserService {

    public static void createUser(User user) {
        try {
            UserRepository.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loginUser(User user) throws SQLException {
        UserRepository.login(user);
    }

    public static List<Book> viewBooks() throws SQLException {
        List<Book> books = LibraryService.getAllBooks();
        return books;
    }

    public boolean canBorrow(User user) {
        return user.borrowedBooks.size() <= 2;
    }

    public static Book borrowBook(String username, String bookname) {

        return null;
    }

    public List<Book> getUserBooks(User user) {
        return UserRepository.getUserBooks(user);
    }

}
