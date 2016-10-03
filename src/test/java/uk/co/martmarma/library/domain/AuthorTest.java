package uk.co.martmarma.library.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void testEquality(){
        Author authorOne = new Author(1, "Mary Berry");
        Author authorTwo = new Author(1, "Mary Berry");
        assertEquals(authorOne, authorTwo);
    }

    @Test
    public void testInequality(){
        Author authorOne = new Author(1, "Mary Berry");
        Author authorTwo = new Author(2, "Mary Berry");
        assertNotEquals(authorOne, authorTwo);
    }

    @Test
    public void testEqualityById() {
        Author authorOne = new Author(1, "Mary Berry");
        Author authorTwo = new Author(1, "Mary B.");
        assertEquals(authorOne, authorTwo);
    }
}