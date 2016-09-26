package uk.co.martmarma.library;

import org.junit.Test;
import uk.co.martmarma.library.domain.Book;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class LibraryTest {


    @Test
    public void getBook() throws Exception {
        Library underTest = new Library();
        Book book = new Book();
        underTest.addBook(book);

        List<Book> allBooks = underTest.getAllBooks();

        assertThat(allBooks, contains(book));
    }

}