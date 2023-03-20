package com.kodilla.abstracts.homework;

public class ShapeApplication {

    public static void main(String[] args) {
        Square square = new Square(4.5);
        Circle circle = new Circle(25.8);
        Triangle triangle = new Triangle(20, 15,
                10, 9);

        getShapeInfo(square);
        getShapeInfo(circle);
        getShapeInfo(triangle);
    }

    private static void getShapeInfo(Shape shape) {
        System.out.println("Surface area of " + shape.getName() + " equals " + shape.getSurfaceArea() + ".");
        System.out.println("Perimeter  of " + shape.getName() + " equals " + shape.getPerimeter() + ".");
    }

}