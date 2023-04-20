package com.kodilla.execution_model.homework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Order> listOfOrders = new ArrayList<>();

    public void addOrder(Order order) {
        this.listOfOrders.add(order);
    }

    public List<Order> getOrdersOnDateRage(SimpleDateFormat dateFrom, SimpleDateFormat dateTo){
        return listOfOrders.stream()
                .filter(order -> order.getDate() >= dateFrom)
                .filter(order -> order.getDate() <= dateTo )
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersOnValueRage(double minValue, double maxValue){
        return listOfOrders.stream()
                .filter(order -> order.getValue() >= minValue)
                .filter(order -> order.getValue() <= maxValue )
                .collect(Collectors.toList());
    }
    public int getNumberOfOrders(){
        return listOfOrders.size();
    }

    public double getSumOfAllOrdersValues(){
        double sumOfValues = 0;
        for(Order order : listOfOrders){
            sumOfValues =sumOfValues + order.getValue();
        }
        return sumOfValues;
    }
}
