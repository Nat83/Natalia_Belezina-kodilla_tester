package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Toyota;

import java.util.Random;

public class CarsApplication {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Car[] cars = new Car[55];
        for (int n = 0; n < cars.length; n++)
            cars[n] = drawCar();
        for ( Car car : cars)
            CarUtils.describeCar(car);
    }
    public static Car drawCar(){

        int drawnCarKind = RANDOM.nextInt(3);     // possible values: 0, 1, 2
        int a = getRandomSpeed();
        if (drawnCarKind == 0)
            return new Ford(a);
        else if (drawnCarKind == 1)
            return new Opel(a);
        else {
            return new Toyota(a);
        }
    }

    private static int getRandomSpeed() {
        return RANDOM.nextInt(100) ;
    }
}
