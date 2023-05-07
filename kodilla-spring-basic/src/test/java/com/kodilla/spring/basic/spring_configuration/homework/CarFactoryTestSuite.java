package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarFactoryTestSuite {
    @Test
    public void testSUVCreated() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext
                ("com.kodilla.spring.basic.spring_configuration.homework");
        SUV suv = context.getBean(SUV.class);
        //When
        String carType = suv.getCarType();
        //Then
        Assertions.assertEquals("SUV", carType);
    }

    @Test
    public void shouldCreateSUVWhenDrivingInWinter() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Car car = (Car) context.getBean("seasonDependentCar");
        //When
        CarFactory carFactory = new CarFactory();
        String chosenType =  carFactory.seasonDependantCar("winter").getCarType();
        System.out.println(chosenType);
        //Then
        Assertions.assertEquals(chosenType , car.getCarType());
    }
}