package com.kodilla.exception.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Warehouse {
    private List<Order> orders;

    public Warehouse() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println(Arrays.toString(orders.toArray()));
    }

    public Order getOrder(String number) throws OrderDoesntExistException {

        orders.stream().filter(order -> order.getNumber().equals(number)).collect(Collectors.toList()).get(0);

        throw new OrderDoesntExistException();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
