import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private int noOfBooks;

    List<Book> borrowedBooks = new ArrayList<>();

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

    boolean canBorrow() {
        if (borrowedBooks.size() >= 2) {
            return false;
        }

        return true;
    }

    boolean borrowBook(Library library, String bookname) {
        Book book = library.issueBook(username, bookname);

        if (book != null) {
            borrowedBooks.add(book);
            return true;
        }

        return false;
    }

    List<Book> getUserBooks() {
        return borrowedBooks;
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

    boolean isBookAvailable() {
        if (this.getNoOfCopies() == 0) {
            return false;
        }

        return true;
    }

}

class Library {

    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

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

    Book getBook(String bookName) {

        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    User getUser(String userName) {

        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    Book issueBook(String username, String bookname) {
        User user = getUser(username);
        Book book = getBook(bookname);

        if (book == null || user == null)
            return null;

        if (user.canBorrow() && book.isBookAvailable()) {
            return book;
        }

        return null;
    }

    void showUserBooks(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                for(Book book: user.getUserBooks()) {
                    System.out.println("Books Borrowed " + book.getBookName());
                }
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
        String username;
        int choice;

        library.addBook(new Book("Top Gear", "BBC", 3));
        library.addBook(new Book("Harry Potter", "JK Rowling", 4));

        library.addUser(new User("Aditya"));

        System.out.println("Menu:-");
        System.out.println("1. View available books");
        System.out.println("2. Borrow a book");
        System.out.println("3. View Your Books");

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

                    System.out.println("Enter your username");
                    username = sc.nextLine();

                    User user = library.getUser(username);

                    if (user.borrowBook(library, bookName)) {
                        System.out.println("Book Borrowed");
                    } else {
                        System.out.println("Cannot Borrow Book");
                    }

                    break;

                case 3:
                    System.out.println("Enter your name");
                    sc.nextLine();
                    username = sc.nextLine();
                    library.showUserBooks(username);

                default:
                    break;
            }
        } while (choice != 4);

        sc.close();

    }
}