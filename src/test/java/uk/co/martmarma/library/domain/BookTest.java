package uk.co.martmarma.library.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BookTest {


    private Set<Author> authors;

    @Before
    public void setUp() throws Exception {
        authors = new HashSet<>(Arrays.asList(new Author(1, "John Smith")));
    }

    @Test
    public void testEquality(){

        Book bookOne = new Book("Title", "2345", authors);
        Book bookTwo = new Book("Title", "2345", authors);

        assertEquals(bookOne, bookTwo);
    }

    @Test
    public void testEqualityByAuthorAndTitle(){
        Book bookOne = new Book("Title", "12345", authors);
        Book bookTwo = new Book("Title", "98765", authors);

        assertEquals(bookOne, bookTwo);
    }


}