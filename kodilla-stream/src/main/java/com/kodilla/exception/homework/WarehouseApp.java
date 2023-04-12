package com.kodilla.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
    Warehouse warehouse = new Warehouse();
    warehouse.addOrder(new Order("2434"));
    warehouse.addOrder(new Order("2456"));
    warehouse.addOrder(new Order("666"));
    warehouse.addOrder(new Order("777"));
        try {
            warehouse.getOrder("777");
        } catch (OrderDoesntExistException e) {
            System.out.println("Given order does not exist");
        }

    }
}
