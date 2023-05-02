package com.kodilla.execution_model.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Order> listOfOrders = new ArrayList<>();

    public void addOrder(Order order) {
        this.listOfOrders.add(order);
    }

    public List<Order> getOrdersOnDateRage(Date dateFrom, Date dateTo) {

        return listOfOrders.stream()
                .filter(order -> order.getDate().compareTo(dateFrom)>=0)
                .filter(order -> order.getDate().compareTo(dateTo)<=0)
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersOnValueRage(double minValue, double maxValue){
        return listOfOrders.stream()
                .filter(order -> order.getValue() >= minValue)
                .filter(order -> order.getValue() <= maxValue)
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

    public Order getOrder(int index) {
        if (index >= 0 && index < listOfOrders.size()) {
            return this.listOfOrders.get(index);
        }
        return null;
    }
}
