package uk.co.martmarma.library;

import org.junit.Test;
import uk.co.martmarma.library.domain.Book;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class LibraryTest {


    @Test
    public void itShouldReturnAllAddedBooks() throws Exception {

        Library underTest = new Library();

        Book book = new Book("title", "123");

        underTest.addBook(book);

        List<Book> allBooks = underTest.getAllBooks();


        assertTrue(allBooks.size() == 1);


        assertThat(allBooks, contains(book));
    }

}