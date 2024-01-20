import java.sql.SQLException;
import java.util.Scanner;

import controller.LibraryController;
import controller.UserController;
import model.Book;
import view.LibraryView;

public class LibraryApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        int choice;

        // libraryController.addBook(new Book("Top Gear", "BBC"));

        do {
            LibraryView.showMenu();

            System.out.println("Enter a choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        UserController.viewBooks();
                    } catch (SQLException e) {
                        System.out.println("Cannot view books");
                    }
                    break;

                case 2:
                    // userController.borrowBook("username", "bookname", libraryController.library, libraryController);
                    break;

                case 3:
                    // LibraryView.showUserBooks(userController.getUserBooks());
                    break;

                case 4:
                    String username = LibraryView.getUsername();
                    userController.createUser(username);
                default:
                    break;
            }
        } while (choice != 5);

        sc.close();

    }
}
