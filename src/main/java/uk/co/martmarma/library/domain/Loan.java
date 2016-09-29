package uk.co.martmarma.library.domain;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final LocalDate returnDate;

    public Loan(final Book book, final LocalDate returnDate){

        this.book = book;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isOverdue(){
        return false;
    }
}
