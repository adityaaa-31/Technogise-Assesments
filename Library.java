import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private int noOfBooks;
    // private List<Book> borrowedBooks = new ArrayList<>();

    public User(String username) {
        this.username = username;
        this.noOfBooks = 0;

    }

    public String getUsername() {
        return username;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

}

class Book {
    private String bookName;
    private String authorName;
    private int noOfCopies;

    public Book(String bookName, String authorName, int noOfCopies) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.noOfCopies = noOfCopies;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

}

class Library {

    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    HashMap<String, String> borrowedBooks = new HashMap<>();

    void addBook(Book b) {
        books.add(b);
    }

    void addUser(User user) {
        users.add(user);
    }

    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty");
        }

        for (Book book : books) {
            System.out.println(book.getBookName() + " - " + book.getAuthorName());
        }
    }

    void borrowBook(String bookName, User user) {
        for (Book book : books) {
            if (book.getBookName() == bookName && user.getNoOfBooks() <= 2) {

                borrowedBooks.put(user.getUsername(), bookName);

                user.setNoOfBooks(user.getNoOfBooks() + 1);
                book.setNoOfCopies(book.getNoOfCopies() - 1);

            } else {
                System.out.println("Cannot Borrow book");
            }
        }
    }

}

class LibrarySystem {
    public static void main(String[] args) {
        // Initialise the library
        Library library = new Library();

        Scanner sc = new Scanner(System.in);

        String bookName;
        int choice;

        library.addBook(new Book("Top Gear", "BBC", 3));
        library.addBook(new Book("Harry Potter", "JK Rowling", 4));

        User user_1 = new User("Aditya");

        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. Exit Library");

        do {
            System.out.println("Enter a choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;

                case 2:
                    System.out.println("Enter the book you want to borrow");
                    sc.nextLine();
                    bookName = sc.nextLine();
                    library.borrowBook(bookName, user_1);

                case 3:
                    System.out.println("Exited");
                    System.exit(1);

                default:
                    break;
            }
        } while (choice != 4);

        sc.close();

    }
}