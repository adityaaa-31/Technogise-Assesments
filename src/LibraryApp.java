import java.util.Scanner;

import model.Book;
import controller.*;

public class LibraryApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        UserController userController = new UserController();

        Scanner sc = new Scanner(System.in);
        int choice;

        libraryController.addBook(new Book("Top Gear", "BBC", 4));

        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. View Your Books");

        do {
            System.out.println("Enter a choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    libraryController.getAllBooks();
                    break;

                case 2:
                    userController.borrowBook(libraryController.library);
                    break;

                case 3:
                    libraryController.showUserBooks();
                    break;

                default:
                    break;
            }
        } while (choice != 4);

        sc.close();

    }
}
