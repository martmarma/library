package uk.co.martmarma.library.domain;


import java.util.Set;

public class Book {

    private final String title;
    private final String isbn;
    private final Set<Author> authors;

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }
}
