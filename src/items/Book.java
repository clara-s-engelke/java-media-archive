package items;

public class Book extends Item {
    private final String author;
    private final long isbn;
    private final int pages;

    public Book(String title, String author, int year, int id, long isbn, int pages) {
        super(title, year, id);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    @Override
    public String displayInfo() {
        if(isbn != -1) {
            return "[Book] " +title + " by " + author + " - ISBN: " + isbn;
        } else{
            return "[Book] " +title + " by " + author + " - ISBN: ";
        }
    }

    @Override
    public String toString(){
        return super.toString() + " by " + author;
    }
}
