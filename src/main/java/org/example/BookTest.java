package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private static Stream<Book> bookProvider() {
        return Stream.of(
                new Book("Book 1", "Jeremy", new Date()),
                new Book("Book 2", "Jeremitraillette", new Date()),
                new Book("Book 3", "Jeremimolette", new Date())
        );
    }

    @DisplayName("Test getTitle method")
    @ParameterizedTest(name = "Test {index}: {0}")
    @MethodSource("bookProvider")
    public void testGetTitle(Book book) {
        assertEquals(book.getTitle(), book.getTitle());
    }

    @DisplayName("Test getAuthor method")
    @ParameterizedTest(name = "Test {index}: {0}")
    @MethodSource("bookProvider")
    public void testGetAuthor(Book book) {
        assertEquals(book.getAuthor(), book.getAuthor());
    }

    @DisplayName("Test getPublicationDate method")
    @ParameterizedTest(name = "Test {index}: {0}")
    @MethodSource("bookProvider")
    public void testGetPublicationDate(Book book) {
        assertEquals(book.getPublicationDate(), book.getPublicationDate());
    }
}
