package com.kodilla.abstracts.homework;

public class Square extends Shape{

    private double squareSide;

    public Square(double squareSide) {
        super("square");
        this.squareSide = squareSide;
    }

    @Override
    public double getSurfaceArea() {
        return squareSide * squareSide;
    }

    @Override
    public double getPerimeter() {
        return 4 * squareSide;
    }
}
