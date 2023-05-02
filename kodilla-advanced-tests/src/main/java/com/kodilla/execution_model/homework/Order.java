package com.kodilla.execution_model.homework;

import java.util.Date;
public class Order {
    private double value;
    private Date date;
    private String login;

    public Order(double value, Date date, String login) {
        this.value = value;
        this.date = date;
        this.login = login;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }
}




