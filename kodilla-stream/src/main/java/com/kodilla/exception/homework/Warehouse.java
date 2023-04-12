package com.kodilla.exception.homework;

import com.kodilla.exception.AirportNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Warehouse {
    List<Order> orders;

    public void addOrder(Order order){
        orders.add(order);

    }
    public Order getOrder(String number) throws OrderDoesntExistException {


        Order searchedOrder = orders
                .stream()
                .filter(order -> order.getNumber().equals(number))
                .collect(Collectors.toList()).get(0);

        return searchedOrder;
    }
}
