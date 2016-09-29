package uk.co.martmarma.library.domain;

import org.junit.Test;
import uk.co.martmarma.library.LibraryTest;

import static org.junit.Assert.*;


public class BookRecordTest {

    @Test
    public void itShouldIncreaseCopiesHeld(){
        Book book = new Book("title", "isbn", LibraryTest.getAuthors());
        BookRecord one = new BookRecord(book, 3);
        one.addCopies(33);
        assertTrue(one.getCopies() == 36);
    }

    @Test
    public void itShouldDecreaseCopies(){
        Book book = new Book("title", "isbn", LibraryTest.getAuthors());
        BookRecord one = new BookRecord(book, 56);
        one.removeCopies(19);
        assertTrue(one.getCopies() == 37);
    }
}