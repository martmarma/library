package uk.co.martmarma.library.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static uk.co.martmarma.library.LibraryTest.getAuthors;

public class LoanTest {


    @Test
    public void itShouldDetectAnOverdueLoan(){
        Loan underTest = new Loan( new Book("title", "isbn", getAuthors()), new Date(123456l));
        assertTrue(underTest.isOverdue());
    }
}