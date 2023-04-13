package com.kodilla.exception.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTestSuite {

    Warehouse warehouse;

    @BeforeEach
    public void setUp(){
        warehouse = new Warehouse();
        warehouse.addOrder(new Order("2434"));
        warehouse.addOrder(new Order("2456"));
        warehouse.addOrder(new Order("666"));
        warehouse.addOrder(new Order("777"));
    }

    @Test
    public void testIsOrderFound() throws OrderDoesntExistException {
        // given
        // when
        Order searchedOrder = warehouse.getOrder("777");
        // then
        assertEquals("777", searchedOrder.getNumber());
    }

    @Test
    public void testIsOrderFound_withException() {
        // given
        // when
        // then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("aaa"));
    }
}