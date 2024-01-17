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