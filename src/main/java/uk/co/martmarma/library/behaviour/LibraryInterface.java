package uk.co.martmarma.library.behaviour;


import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;
import uk.co.martmarma.library.domain.BookRecord;
import uk.co.martmarma.library.domain.Loan;

import java.util.List;
import java.util.Set;

public interface LibraryInterface {

    void addBook(Book book);

    Book getBook(String isbn);

    Set<Book> getBooksByAuthor(Author author);

    List<Book> getAllBooks();

    List<Book> getBooksByTitle(String title);

    int getNumberOfCopiesHeld(Book book);

    BookRecord getBookRecordForBook(Book book);

    Loan loanBook(Book book);

    List<Loan> getAllLoans();

}
