package uk.co.martmarma.library.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {



    @Test
    public void testEquality(){

        Book bookOne = new Book("Title", "2345");
        Book bookTwo = new Book("Title", "2345");

        assertEquals(bookOne, bookTwo);
    }


}