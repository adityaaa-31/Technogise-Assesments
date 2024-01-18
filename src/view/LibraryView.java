package view;

import java.util.List;

import model.Book;

public class LibraryView {

    public static void showUserBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Books Borrowed " + books.get(i).getBookName());
        }
    }
}
