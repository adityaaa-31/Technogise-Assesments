import java.util.List;

public class View {

    void showUserBooks(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                List<Book> books = user.getUserBooks();
                for (int i = 0; i < books.size(); i++) {
                    System.out.println("Books Borrowed " + book.getBookName());
                }
            }

        }
    }
}