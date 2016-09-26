package uk.co.martmarma.library;

import uk.co.martmarma.library.behaviour.LibraryInterface;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;

import java.util.Set;

public class Library implements LibraryInterface {

    @Override
    public void addBook(Book book) {

    }

    @Override
    public Book getBook(String isbn) {
        return null;
    }

    @Override
    public Set<Book> getBooksByAuthor(Author author) {
        return null;
    }
}
