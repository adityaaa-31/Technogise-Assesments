package view;

import java.util.List;

import model.Book;
import model.Library;

public class LibraryView {

    public static void showUserBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Books Borrowed " + books.get(i).getBookName());
        }
    }

    public static void showAllBooks(Library library) {
        for (Book book : library.books) {
            System.out.println(book.getBookName());
        }
    }

    public static void showMenu() {
        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. View Your Books");
    }
}
