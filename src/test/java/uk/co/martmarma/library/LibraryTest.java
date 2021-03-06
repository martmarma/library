package uk.co.martmarma.library;

import org.junit.Before;
import org.junit.Test;
import uk.co.martmarma.library.domain.Author;
import uk.co.martmarma.library.domain.Book;
import uk.co.martmarma.library.domain.BookRecord;
import uk.co.martmarma.library.domain.Loan;
import uk.co.martmarma.library.domain.Fine;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

public class LibraryTest {


    private Library underTest;
    private Set<Author> authors;
    private Book book, book1, book2;

    @Before
    public void setUp() throws Exception {
        underTest = new Library();
        authors = getAuthors();
        book = new Book("title", "123", authors);
        book1 = new Book("New Title", "999", authors);
        book2 = new Book("title2", "154878", authors);
    }

    public static HashSet<Author> getAuthors() {
        return new HashSet<>(Arrays.asList(new Author(1, "John Smith")));
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

        Book needle = new Book("Needle", "1234", new HashSet<>(Arrays.asList(author)));
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
        addAllBoooks();
        Book foundBook = underTest.getBook("999");
        assertEquals(book1, foundBook);
    }

    @Test
    public void itFindsAnotherBookByISBN(){
        addAllBoooks();
        Book foundBook = underTest.getBook("123");
        assertEquals(book, foundBook);
    }

    @Test
    public void itFindsABookByTitle(){
        addAllBoooks();
        List<Book> booksByTitle = underTest.getBooksByTitle("New Title");
        assertTrue(booksByTitle.size() == 1);
        assertThat(booksByTitle, contains(book1));
    }

    @Test
    public void itFindsABookByAnotherTitle(){
        addAllBoooks();
        List<Book> booksByTitle = underTest.getBooksByTitle("title");
        assertTrue(booksByTitle.size() == 1);
        assertThat(booksByTitle, contains(book));
    }

    @Test
    public void itReturnsAnEmptyListWhenTitleNotFound(){
        List<Book> booksByTitle = underTest.getBooksByTitle("some title");
        assertTrue(booksByTitle.isEmpty());
    }

    @Test
    public void itReturnsNumberOfCopiesHeld(){
        addAllBoooks();
        addAllBoooks();
        int numberOfCopiesHeld = underTest.getNumberOfCopiesHeld(book1);
        assertTrue(numberOfCopiesHeld == 2);
    }

    @Test
    public void itRetunsTheBookRecord(){
        addAllBoooks();
        addAllBoooks();
        BookRecord bookRecordForBook = underTest.getBookRecordForBook(book2);
        assertTrue(bookRecordForBook.getCopies() == 2);
    }

    @Test
    public void itIssuesOneMonthLoan(){
        addAllBoooks();
        LocalDate expectedReturnDate = LocalDate.now().plus(Period.ofMonths(1));
        Loan loan = underTest.loanBook(book);
        assertEquals(expectedReturnDate, loan.getReturnDate());
    }

    @Test
    public void itShouldBeAbleToTellTotalBooksOnLoan(){
        addAllBoooks();
        underTest.loanBook(book);
        underTest.loanBook(book1);
        List<Loan> allLoans = underTest.getAllLoans();
        assertTrue(allLoans.size() == 2);
    }

    @Test
    public void itDetectsFines(){
        LocalDate inThePast = LocalDate.now().minus(Period.ofDays(3));
        Loan expiredLoan = new Loan(book1, inThePast);
        Fine fine = underTest.issueFine(expiredLoan);
        assertTrue(fine.getAmount() == 3);//assume £1 per day
    }

    @Test
    public void itDoesNotIssueFinesIfLoanInDate(){
        LocalDate inTheFuture = LocalDate.now().plus(Period.ofDays(3));
        Loan loan = new Loan(book1, inTheFuture);
        Fine fine = underTest.issueFine(loan);
        assertNull(fine);
    }
    
    private void addAllBoooks() {
        underTest.addBook(book);
        underTest.addBook(book1);
        underTest.addBook(book2);
    }

}