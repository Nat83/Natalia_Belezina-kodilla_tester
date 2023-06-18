package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BookHackedTest {

    BookHacked bookHacked;

    @Test
    void  canModifyTitle(){
        //Given
        bookHacked = new BookHacked("Autor ABC", "Title ABC");
        //When
        bookHacked.modifyTitle("Title Changed");
        //Then
        Assertions.assertEquals(bookHacked.getTitle(), "Title Changed");

    }
}