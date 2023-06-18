package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Toyota;
import com.kodilla.collections.interfaces.homework.Opel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarUtilsTestSuite {

    private Ford ford;
    private Opel opel;
    private Toyota toyota;

    private Car differentCar;

    @BeforeEach
    void setUp() {
        ford = new Ford(100);
        opel = new Opel(100);
        toyota = new Toyota(100);
        differentCar = new Car() {
            @Override
            public int getSpeed() {
                return 0;
            }

            @Override
            public int increaseSpeed() {
                return 0;
            }

            @Override
            public int decreaseSpeed() {
                return 0;
            }

            @Override
            public String getName() {
                return null;
            }
        };
    }

    @Test
    void shouldDescribeCar() {
        //Given
        //When
        //Then
        CarUtils.describeCar(ford);
        CarUtils.describeCar(opel);
        CarUtils.describeCar(toyota);
    }
    @Test
    void getCarNameForFord() {
        Assertions.assertEquals("Ford", CarUtils.getCarName(ford));
    }

    @Test
    void getCarNameForOpel() {
        Assertions.assertEquals("Opel", CarUtils.getCarName(opel));
    }

    @Test
    void getCarNameForToyota() {
        Assertions.assertEquals("Toyota", CarUtils.getCarName(toyota));
    }

    @Test
    void getErrorMessageWhenIncorrectCarName () {
        Assertions.assertEquals("Unknown car name", CarUtils.getCarName(differentCar));
    }

}