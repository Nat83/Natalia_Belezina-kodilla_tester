package com.kodilla.abstracts.homework;

public class Triangle extends Shape {

    private final double triangleHigh;
    private final double triangleBase;
    private final double triangleSideA;
    private final double triangleSideB;

    public Triangle(double triangleHigh, double triangleBase, double triangleSideA, double triangleSideB) {
        super("triangle");
        this.triangleHigh = triangleHigh;
        this.triangleBase = triangleBase;
        this.triangleSideA = triangleSideA;
        this.triangleSideB = triangleSideB;
    }

    public double getSurfaceArea() {
        return 0.5 * triangleBase * triangleHigh;
    }

    @Override
    public double getPerimeter() {
        return triangleBase + triangleSideA + triangleSideB;
    }
}
