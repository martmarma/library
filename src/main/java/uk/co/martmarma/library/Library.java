package uk.co.martmarma.library;

import uk.co.martmarma.library.behaviour.LibraryInterface;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;

import java.util.*;

public class Library implements LibraryInterface {

    List<Book> books = new ArrayList<Book>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBook(String isbn) {

        for (Book book : books) {
            if (isbn == book.getIsbn()) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Set<Book> getBooksByAuthor(Author author) {
        Set<Book> foundBooks = new HashSet<>();

        for(Book myBook:books){
            Set<Author> authors = myBook.getAuthors();
            if (authors.contains(author)){
                foundBooks.add(myBook);
            }
        }

        return foundBooks;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

}
