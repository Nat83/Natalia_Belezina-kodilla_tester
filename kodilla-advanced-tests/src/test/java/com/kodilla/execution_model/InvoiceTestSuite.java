package com.kodilla.execution_model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTestSuite {

    Invoice invoice = new Invoice();
    Item milk = new Item("Milk", 3.50);
    Item eggs = new Item("Eggs", 8.00);
    Item bread = new Item("Bread", 4.15);

    @BeforeAll
    public static void displayIntroMessage() {
        System.out.println("Starting testing");
    }

    @AfterAll
    public static void displayGoodByeMessage() {
        System.out.println("Finishing testing");
    }

    @BeforeEach
    public void initializeInvoice() {
        invoice.addItem(milk);
        invoice.addItem(eggs);
        invoice.addItem(bread);
    }

    @Test
    public void shouldAddItemToInvoice() {
        //Given
        //When
        int numberOfItems = invoice.getSize();
        //Then
        assertEquals(3, numberOfItems);
    }

    @Test
    public void shouldGetExistingItem() {
        //Given
        //When
        Item chosenItem = invoice.getItem(1);
        //Then
        assertEquals("Eggs", chosenItem.getName());
        assertEquals(8.00, chosenItem.getPrice());
    }

    @Test
    public void shouldReturnNullWhenIndexNegative() {
        //Given
        //When
        Item chosenItem = invoice.getItem(-1);
        //Then
        assertNull(chosenItem);
    }

    @Test
    public void shouldReturnNullWhenIndexTooBig() {
        //Given
        //When
        Item chosenItem = invoice.getItem(6);
        //Then
        assertNull(chosenItem);
    }

    @Test
    public void shouldClearInvoise() {
        //Given
        int numberOfItemsBeforeClear = invoice.getSize();
        //When
        invoice.clear();
        int numberOfItemsAfterClear = invoice.getSize();
        //Then
        assertEquals(3, numberOfItemsBeforeClear);
        assertEquals(0, numberOfItemsAfterClear);
    }

    @AfterEach
    public void resetValues() {
        System.out.println("Resetting values...");
    }
}