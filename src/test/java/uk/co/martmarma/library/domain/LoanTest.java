package uk.co.martmarma.library.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static org.junit.Assert.*;
import static uk.co.martmarma.library.LibraryTest.getAuthors;

public class LoanTest {


    @Test
    public void itShouldDetectAnOverdueLoan(){
        LocalDate someDateInThePast = LocalDate.now().minusDays(12l);
        Loan underTest = new Loan( new Book("title", "isbn", getAuthors()), someDateInThePast);
        assertTrue(underTest.isOverdue());
    }

    @Test
    public void itShouldDetectNonOverdueLoans(){
        LocalDate someDateInTheFuture = LocalDate.now().plus(Period.ofMonths(1));
        Loan loan = new Loan(new Book("title", "isbn", getAuthors()), someDateInTheFuture);
        assertFalse(loan.isOverdue());
    }

    @Test
    public void itShouldNotBeOverdueOnTheSameDate() {
        LocalDate presentDate = LocalDate.now();
        Loan loan = new Loan(new Book("title", "isbn", getAuthors()), presentDate);
        assertFalse(loan.isOverdue());
    }
}