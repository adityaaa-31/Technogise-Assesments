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