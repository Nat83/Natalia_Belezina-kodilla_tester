package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarFactoryTestSuite {

    @Test
    public void shouldCreateCorrectCarBeanDependingTheSeason() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Car car = (Car) context.getBean("seasonDependantCar");
        //When
        String chosenType =  car.getCarType();
        System.out.println("Car type is " + chosenType + " because today date is " + LocalDate.now());
        //Then
        List<String> possibleTypes = Arrays.asList("SUV", "Sedan", "Cabrio", "Default");
        Assertions.assertTrue(possibleTypes.contains(chosenType));
    }

    @ParameterizedTest
    @CsvSource(value = {"20:00:00,06:00:00","20:00:01,05:00:59"})
    public void cabrioCarHaveLightsTurnedOnDuringNight(String hourFrom, String hourTo) {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Car cabrio = (Car) context.getBean("seasonDependantCar");
        //When
        boolean lightsTurnedOn = cabrio.hasHeadlightsTurnedOn(LocalTime.parse(hourFrom), LocalTime.parse(hourTo));
        //Then
        assertTrue(lightsTurnedOn);
    }

    @ParameterizedTest
    @CsvSource(value = {"19:59:00,06:01:00","19:59:59,06:01:01"})
    public void SUVCarHaveLightsTurnedOfDuringDay(String hourFrom, String hourTo) {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Car suv = (Car) context.getBean("seasonDependantCar");
        //When
        boolean lightsTurnedOn = suv.hasHeadlightsTurnedOn(LocalTime.parse(hourFrom), LocalTime.parse(hourTo));
        //Then
        assertFalse(lightsTurnedOn);
    }
}
