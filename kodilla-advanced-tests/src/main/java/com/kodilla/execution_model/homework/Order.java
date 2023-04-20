package com.kodilla.execution_model.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private double value;
    private SimpleDateFormat date;
    private String login;

    public Order(double value, SimpleDateFormat date, String login) {
        this.value = value;
        this.date = date;
        this.login = login;
    }

    public double getValue() {
        return value;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }
}
