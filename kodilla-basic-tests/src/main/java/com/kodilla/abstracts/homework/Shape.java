package com.kodilla.abstracts.homework;

public abstract class Shape {

    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getSurfaceArea();
    public abstract double getPerimeter();

    public String getName() {
        return name;
    }
}
