import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String bookName;
    private String authorName;

    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}

class Library {

    // Library will have a lsit of books
    List<Book> books = new ArrayList<>();

    // View the books currently present in the library
    void viewBooks() {
        // If there are no books present, notify the user
        if (books.isEmpty()) {
            System.out.println("Library is Empty");
        }

        for (Book book : books) {
            System.out.println(book.getBookName() + " - " + book.getAuthorName());
        }
    }

    // Add books to the library
    void addBook(Book b) {
        books.add(b);
    }

}

class LibrarySystem {
    public static void main(String[] args) {
        // Initialise the library
        Library library = new Library();

        Scanner sc = new Scanner(System.in);

        library.addBook(new Book("Top Gear", "BBC"));
        library.addBook(new Book("Harry Potter", "JK Rowling"));

        // library.viewBooks();

        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Exit Library");

        int choice;
        do {
            System.out.println("Enter a choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;

                case 2:
                    System.out.println("Exited");
                    System.exit(1);
                default:
                    break;
            }
        } while (choice != 3);

        sc.close();

    }
}