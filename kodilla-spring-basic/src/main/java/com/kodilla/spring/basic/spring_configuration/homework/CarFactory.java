package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;

@Configuration
public class CarFactory {

    @Bean
    public Car seasonDependantCar(String season) {
        Car car;
        if (season == "winter") {
            car = new SUV();
        } else if (season == "summer") {
            car = new Cabrio();
        } else {
            car = new Sedan();
        }
        return car;
    }
}
