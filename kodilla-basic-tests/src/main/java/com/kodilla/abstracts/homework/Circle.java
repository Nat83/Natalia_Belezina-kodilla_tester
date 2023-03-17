package com.kodilla.abstracts.homework;

public class Circle extends Shape{
    private static double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        super("circle");
        this.radius = radius;
    }

    @Override
    public double getSurfaceArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
