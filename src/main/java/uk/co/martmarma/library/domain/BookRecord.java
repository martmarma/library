package uk.co.martmarma.library.domain;

public class BookRecord {

    private final Book book;
    private  int copies;


    public BookRecord(final Book book, final int copies){

        this.book = book;
        this.copies = copies;
    }

    public void addCopies(final int copies){
        this.copies = this.copies + copies;
    }

    public Book getBook() {
        return book;
    }

    public int getCopies() {
        return copies;
    }

    public void removeCopies(final int copies) {
        this.copies = this.copies - copies;
    }
}
