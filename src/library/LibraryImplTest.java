package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import library.Book;
import library.Library;
import library.LibraryImpl;

import static org.junit.jupiter.api.Assertions.*;

class LibraryImplTest {

    Library library;
    Book[] book;

    @BeforeEach
    void setUp() {
        library = new LibraryImpl(6);
        book = new Book[4];
        book[0] = new Book(100l, "Agata Cristi", "Detective", 1920);
        book[1] = new Book(101l, "Agata Cristi", "Detective", 1922);
        book[2] = new Book(102l, "Conan Doily", "Detective", 1923);
        book[3] = new Book(103l, "Edgar Po", "Detective", 1924);

        for (int i = 0; i < book.length; i++) {
            library.addBook(book[i]);

        }
    }

    @Test
    void addBook() {
        library.printBook();
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(book[3]));
        System.out.println();
        Book book1 = new Book(104l, "Agata Cristi", "Detective", 1926);
        assertTrue(library.addBook(book1));
        assertEquals(5, library.quantity());
        library.printBook();
        System.out.println();
        Book book2 = new Book(105l, "Agata Cristi", "Detective", 1928);
        assertTrue(library.addBook(book2));
        assertEquals(6, library.quantity());
        library.printBook();
        Book book3 = new Book(106l, "Agata Cristi", "Detective", 1929);
        assertFalse(library.addBook(book3));
        assertEquals(6, library.quantity());
    }

    @Test
    void removeBookTest() {
        library.printBook();
        assertEquals(book[1], library.removeBook(101l));
        assertEquals(3, library.quantity());
        System.out.println();
        library.printBook();
        assertEquals(book[3], library.removeBook(103l));
        assertEquals(2, library.quantity());
        System.out.println();
        library.printBook();
        assertNull(library.removeBook(101l));
        assertNull(library.removeBook(103l));
        assertNull(library.findBook(101l));
        assertNull(library.findBook(103l));

    }

    @Test
    void findBookTest() {
        library.printBook();
        assertEquals(book[1], library.findBook(101l));
        assertEquals(book[3], library.findBook(103l));
        assertNull(library.findBook(105));
    }

    @Test
    void quantityTest() {
        library.printBook();
        assertEquals(4, library.quantity());
    }

    @Test
    void printBookTest() {
        library.printBook();
    }

    @Test
    void findBookByAuthorTest() {
        library.printBook();
        Book[] actual = library.findBookByAuthor("Agata Cristi");
        Book[] expected = {book[0], book[1]};
        assertArrayEquals(actual, expected);

    }
}