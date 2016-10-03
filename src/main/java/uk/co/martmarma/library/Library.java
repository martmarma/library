package uk.co.martmarma.library;

import uk.co.martmarma.library.behaviour.LibraryInterface;
import uk.co.martmarma.library.domain.*;

import java.time.LocalDate;

import java.time.Period;
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
        int numberOfCopies = 0;

        for (Book book1 : books) {
            if (book1.equals(book)){
                numberOfCopies ++;
            }
        }
        return numberOfCopies;
    }

    @Override
    public BookRecord getBookRecordForBook(Book book) {
        BookRecord aBookRecord = new BookRecord(book, getNumberOfCopiesHeld(book));

        return aBookRecord;
    }

    @Override
    public Loan loanBook(Book book) {
        Loan aLoan = new Loan(book, LocalDate.now().plus(Period.ofMonths(1)));
        booksOnLoan.add(aLoan);
        return aLoan;
    }

    @Override
    public List<Loan> getAllLoans() {
        return booksOnLoan;
    }

    public Fine issueFine(Loan expiredLoan) {
        Fine theFine = new Fine(expiredLoan);
        if (expiredLoan.isOverdue() == false) {
            return null;
        }

        return theFine;
    }


}
