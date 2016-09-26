package uk.co.martmarma.library.behaviour;


import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;

import java.util.Set;

public interface LibraryInterface {

  void addBook(Book book);
    Book getBook(String isbn);
    Set<Book> getBooksByAuthor(Author author);
}
