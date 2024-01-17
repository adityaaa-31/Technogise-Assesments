package view;

import java.util.List;

import model.Book;
import model.User;
import model.Library;

public class View extends Library{

    public void showUserBooks(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                List<Book> books = user.getUserBooks();
                for (int i = 0; i < books.size(); i++) {
                    System.out.println("Books Borrowed " + books.get(i).getBookName());
                }
            }

        }
    }
}
