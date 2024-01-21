package view;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Library;

public class LibraryView {

    static Scanner scanner = new Scanner(System.in);

    public static String getUsername() {
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        return username;
    }

    public static String getAuthorname() {
        System.out.println("Enter the author name");
        String username = scanner.nextLine();
        return username;
    }

    public static String getBookName() {
        System.out.println("Enter a book name");
        String bookname = scanner.nextLine();
        return bookname;
    }

    public static void showUserBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Books Borrowed " + books.get(i).getBookName());
        }
    }

    public static void showAllBooks(List<Book> books) {
        System.out.println("Books present in the library");

        for (Book book : books) {
            System.out.println(book.getBookName());
        }
    }

    public static void showMenu() {
        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. View Your Books");
        System.out.println("4. Add User");
        System.out.println("4. Add Book");

    }
}
