package uk.co.martmarma.library;

import uk.co.martmarma.library.behaviour.LibraryInterface;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Library implements LibraryInterface {

    List<Book> books = new ArrayList<Book>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBook(String isbn) {
        return null;
    }

    @Override
    public Set<Book> getBooksByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

}
