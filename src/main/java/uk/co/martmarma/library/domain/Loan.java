package uk.co.martmarma.library.domain;

import java.util.Date;

public class Loan {

    private final Book book;
    private final Date returnDate;

    public Loan(final Book book, final Date returnDate){

        this.book = book;
        this.returnDate = returnDate;
    }

    public boolean isOverdue(){
        return false;
    }
}
