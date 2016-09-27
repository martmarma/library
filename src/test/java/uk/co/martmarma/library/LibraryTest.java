package uk.co.martmarma.library;

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


    @Test
    public void itShouldReturnAllAddedBooks() throws Exception {

        Library underTest = new Library();

        Set<Author> authors = new HashSet<>(Arrays.asList(new Author(1, "John Smith")));

        Book book = new Book("title", "123", authors);

        underTest.addBook(book);

        List<Book> allBooks = underTest.getAllBooks();


        assertTrue(allBooks.size() == 1);


        assertThat(allBooks, contains(book));
    }

}