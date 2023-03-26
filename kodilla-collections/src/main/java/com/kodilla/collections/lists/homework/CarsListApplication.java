package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Toyota;

import java.util.ArrayList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Ford(90));
        cars.add(new Opel(120));
        Toyota toyota = new Toyota(50);
        cars.add(toyota);

        cars.remove(0);
        cars.remove(toyota);

        System.out.println(cars.size());
        for (Car car : cars) {
            CarUtils carUtils = new CarUtils();
            carUtils.describeCar(car);
        }
    }
}
