package com.kodilla.rest.domain;

import java.util.Objects;

public class BookDto {
    private String title;
    private String author;

    public BookDto() {  
    }

    public BookDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(title, bookDto.title) && Objects.equals(author, bookDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    public BookDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }
}
