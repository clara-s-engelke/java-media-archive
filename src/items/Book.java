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
        return title + " by " + author + " - ISBN: " + isbn;
    }

    @Override
    public String toString(){
        return super.toString() + " by " + author;
    }
}
