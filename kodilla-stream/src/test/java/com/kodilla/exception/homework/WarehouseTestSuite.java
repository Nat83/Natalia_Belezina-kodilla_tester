package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTestSuite {

    @Test
    public void testIsOrderFound() throws OrderDoesntExistException {
        // given
        Warehouse warehouse = new Warehouse();
        // when
        Order searchedOrder = warehouse.getOrder("777");
        // then
        assertEquals("777", searchedOrder.getNumber());
    }

    @Test
    public void testIsOrderFound_withException() throws OrderDoesntExistException {
        // given
        Warehouse warehouse = new Warehouse();
        // when
        // then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("777"));
    }
}