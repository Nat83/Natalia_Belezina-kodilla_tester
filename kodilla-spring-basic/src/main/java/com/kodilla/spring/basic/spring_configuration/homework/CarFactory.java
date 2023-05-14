package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Configuration
public class CarFactory {
    private final DateTimeFormatter dateTimeFormatter;

    public CarFactory() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Bean
    public Car seasonDependantCar() {
        Car car;

        if (LocalDate.now().isAfter(LocalDate.parse("2022-12-21", dateTimeFormatter))
                && LocalDate.now().isBefore(LocalDate.parse("2023-03-21", dateTimeFormatter)))
            car = new SUV();
        else if (LocalDate.now().isAfter(LocalDate.parse("2023-06-21", dateTimeFormatter))
            && LocalDate.now().isBefore(LocalDate.parse("2023-09-24", dateTimeFormatter)))
            car = new Cabrio();
        else if ((LocalDate.now().isAfter(LocalDate.parse("2023-03-20", dateTimeFormatter)) &&
                LocalDate.now().isBefore(LocalDate.parse("2023-06-22", dateTimeFormatter))) ||
                (LocalDate.now().isAfter(LocalDate.parse("2023-09-23", dateTimeFormatter)) &&
                        LocalDate.now().isBefore(LocalDate.parse("2023-11-30", dateTimeFormatter))))
            car = new Sedan();
        else
            car = new DefaultCar();

        return car;
        }
    }

