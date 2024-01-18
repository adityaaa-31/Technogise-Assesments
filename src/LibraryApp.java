import java.util.Scanner;

import model.Book;
import view.LibraryView;
import controller.*;

public class LibraryApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        UserController userController = new UserController();

        Scanner sc = new Scanner(System.in);
        int choice;

        libraryController.addBook(new Book("Top Gear", "BBC", 4));

        do {
            LibraryView.showMenu();

            System.out.println("Enter a choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    libraryController.getAllBooks();
                    break;

                case 2:
                    userController.borrowBook(libraryController.library, libraryController);
                    break;

                case 3:
                    LibraryView.showUserBooks(userController.getUserBooks());
                    break;

                default:
                    break;
            }
        } while (choice != 4);

        sc.close();

    }
}
