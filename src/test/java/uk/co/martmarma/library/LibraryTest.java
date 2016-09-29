package uk.co.martmarma.library;

import org.junit.Before;
import org.junit.Test;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class LibraryTest {


    private Library underTest;
    private Set<Author> authors;
    private Book book, book1;

    @Before
    public void setUp() throws Exception {
        underTest = new Library();
        authors = new HashSet<>(Arrays.asList(new Author(1, "John Smith")));
        book = new Book("title", "123", authors);
        book1 = new Book("New Title", "999", authors);
    }

    @Test
    public void itShouldReturnAllAddedBooks() throws Exception {
        underTest.addBook(book);
        List<Book> allBooks = underTest.getAllBooks();
        assertTrue(allBooks.size() == 1);
        assertThat(allBooks, contains(book));
    }

    @Test
    public void itFindsBooksByAuthor(){
        Author author = new Author(8, "Sue Bell");
        HashSet<Author> authors = new HashSet<>(Arrays.asList(author));
        Book needle = new Book("Needle", "1234", authors);
        underTest.addBook(needle);

        Set<Book> booksByAuthor = underTest.getBooksByAuthor(author);
        assertTrue(booksByAuthor.size() == 1);
        assertThat(booksByAuthor, contains(needle));
    }

    @Test
    public void itFindsBooksByAnotherAuthor(){
        Author author = new Author(10, "Sue Bell");
        HashSet<Author> authors = new HashSet<>(Arrays.asList(author));
        Book needle = new Book("A New Needle", "9876", authors);
        underTest.addBook(needle);

        Set<Book> booksByAuthor = underTest.getBooksByAuthor(author);
        assertTrue(booksByAuthor.size() == 1);
        assertThat(booksByAuthor, contains(needle));
    }

    @Test
    public void itFindsABookByISBN(){
        underTest.addBook(book);
        underTest.addBook(book1);
        Book foundBook = underTest.getBook("999");
        assertEquals(book1, foundBook);
    }

    @Test
    public void itFindsAnotherBookByISBN(){
        underTest.addBook(book);
        underTest.addBook(book1);
        Book foundBook = underTest.getBook("123");
        assertEquals(book, foundBook);
    }

}