class Library {

    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void addUser(User user) {
        users.add(user);
    }

    Book issueBook(String username, String bookname) {
        User user = libraryController.getUser(username);
        Book book = libraryController.getBook(bookname);

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