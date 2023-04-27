package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.*;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

class ShopTestSuite {
    Shop shop = new Shop();
    Order order1 = new Order(20.05, "20/05/2023", "emuraczewski" );
    Order order2 = new Order(8.45, "21/04/2023", "asokulska" );
    Order order3 = new Order(15.75, "05/03/2023", "nbajor" );
    ;

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
        shop.addOrder(order1);
        shop.addOrder(order2);
        shop.addOrder(order3);    }

    @Test
    public void shouldAddOrdersToShop() {
        //Given
        //When
        int numberOfOrders = shop.getNumberOfOrders();
        //Then
        assertEquals(3, numberOfOrders);
    }

    @Test
    public void shouldGetExistingOrder() throws ParseException {
        //Given
        //When
        Order chosenOrder = shop.getOrder(0);
        //Then
        assertEquals(20.05, chosenOrder.getValue());
        assertEquals("20/05/2023", chosenOrder.getDate().toString());
        assertEquals("emuraczewski", chosenOrder.getLogin());
    }

    @Test
    public void shouldReturnNullWhenIndexNegative() {
        //Given
        //When
        Order chosenOrder = shop.getOrder(-2);
        //Then
        assertNull(chosenOrder);
    }

    @Test
    public void shouldReturnNullWhenIndexTooBig() {
        //Given
        //When
        Order chosenOrder = shop.getOrder(9);
        //Then
        assertNull(chosenOrder);
    }

    @Test
    public void shouldReturnCorrectOrdersInGivenValueRange (){
        //Given
        int numberOfAllOrders = shop.getNumberOfOrders();
        //When
        int numberOfOrdersWithGivenValueRange = shop.getOrdersOnValueRage(2.00, 10.00).size();
        //Then
        assertEquals(3, numberOfAllOrders);
        assertEquals(1, numberOfOrdersWithGivenValueRange);
    }
    @Test
    public void shouldReturnCorrectOrdersInGivenDateRange () throws ParseException {
        //Given
        int numberOfAllOrders = shop.getNumberOfOrders();
        //When
        shop.getOrdersOnDateRage("01/04/2023", "30/05/2023");
        int numberOfOrdersWithGivenDateRange = shop.getNumberOfOrders();
        //Then
        assertEquals(3, numberOfAllOrders);
        assertEquals(2, numberOfOrdersWithGivenDateRange);
    }
    @Test
    public void shouldReturnCorrectSumOfAllOrders(){
        //Given
        //When
        double sumOfValuesOfAllOrders = shop.getSumOfAllOrdersValues();
        //Then
        assertEquals(44.25, sumOfValuesOfAllOrders);
    }

    @AfterEach
    public void resetValues() {
        System.out.println("Resetting values...");
    }

}