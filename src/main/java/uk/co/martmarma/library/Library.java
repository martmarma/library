package uk.co.martmarma.library;

import uk.co.martmarma.library.behaviour.LibraryInterface;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;
import uk.co.martmarma.library.domain.BookRecord;
import uk.co.martmarma.library.domain.Loan;

import java.util.*;

public class Library implements LibraryInterface {

    List<Book> books = new ArrayList<>();
    List<Loan> booksOnLoan = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBook(String isbn) {

        for (Book book : books) {
            if (isbn.equals(book.getIsbn())) {
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

    @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> listOfBooks = new ArrayList<>();
        for (Book book : books) {
            if(title.equals(book.getTitle())){
                listOfBooks.add(book);
            }
        }


        return listOfBooks;
    }

    @Override
    public int getNumberOfCopiesHeld(Book book) {
        return 0;
    }

    @Override
    public BookRecord getBookRecordForBook(Book book) {
        return null;
    }

    @Override
    public Loan loanBook(Book book) {
        return null;
    }

    @Override
    public List<Loan> getAllLoans() {
        return null;
    }

}
