package com.kodilla.hibernate.task;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TASKS_FINANCIALS")
public class TaskFinancialDetails {
    private int id;
    private BigDecimal price;
    boolean paid;

    @Id
    public int getId() {
        return id;
    }

    public TaskFinancialDetails setId(int id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TaskFinancialDetails setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public boolean isPaid() {
        return paid;
    }

    public TaskFinancialDetails setPaid(boolean paid) {
        this.paid = paid;
        return this;
    }
}
