import java.sql.SQLException;
import java.util.Scanner;

import controller.BookController;
import controller.LibraryController;
import controller.UserController;
import model.Book;
import model.User;
import repository.UserRepository;
import view.LibraryView;

public class LibraryApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        int choice;

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
                    // userController.borrowBook("username", "bookname", libraryController.library,
                    // libraryController);
                    break;

                case 3:
                    // LibraryView.showUserBooks(userController.getUserBooks());
                    break;

                case 4:
                    System.out.println("Enter Username");
                    sc.nextLine();
                    String username = sc.nextLine();

                    System.out.println("Enter password");
                    String password = sc.nextLine();
                    User user = userController.createUser(username, password);
                    System.out.println("User " + user.getUsername() + " Created");

                    break;

                case 5:
                    System.out.println("Enter Username");
                    sc.nextLine();
                    String uname = sc.nextLine();

                    System.out.println("Enter password");
                    String pwd = sc.nextLine();
                   
                    try {
                        userController.loginUser(uname, pwd);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("Enter book name");
                    sc.nextLine();
                    String bookname = sc.nextLine();
                    System.out.println("Enter author name");
                    String authorname = sc.nextLine();

                    try {
                        Book book = LibraryController.saveBook(bookname, authorname);
                        System.out.println(book);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Cannot save book");
                    }

                default:
                    break;
            }
        } while (choice != 7);

        sc.close();

    }
}
