package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest {


    @Test
    void shouldFetchBooks() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("Title 1", "Author 1"));
        booksList.add(new BookDto("Title 2", "Author 2"));
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);

        //when
        List<BookDto> result = bookController.getBooks();

        //then
        assertThat(result).hasSize(2);
    }

    @Test
    void canAddBook() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        List<BookDto> booksList = new ArrayList<>();
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);
        BookDto addedBook = (new BookDto("Title 1", "Author 1"));
        //when
        bookController.addBook(addedBook);
        //then
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(addedBook);
    }

    @Test
    void canAddBookWithTheSameDataMultipleTimes() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto addedBook = (new BookDto("Title 1", "Author 1"));
        //when
        bookController.addBook(addedBook);
        bookController.addBook(addedBook);
        bookController.addBook(addedBook);
        //then
        Mockito.verify(bookServiceMock, Mockito.times(3)).addBook(addedBook);

    }
    @Test
    void canAddDifferentBooks() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto addedBook = (new BookDto("Title 1", "Author 1"));
        BookDto addedBook2 = (new BookDto("Title 2", "Author 2"));
        //when
        bookController.addBook(addedBook);
        bookController.addBook(addedBook2);
        //then
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(addedBook);
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(addedBook2);
    }
}