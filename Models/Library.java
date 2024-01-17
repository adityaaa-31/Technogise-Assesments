import java.util.ArrayList;
import java.util.List;

class Library {

    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void addUser(User user) {
        users.add(user);
    }

    List<Book> getBooks() {

        if (books.isEmpty()) {
            System.out.println("Library is Empty");
        }

        return books;
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



}