package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClockTestSuite {

    @Test
    public void shouldCreateDifferentClockBeans() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Clock clockBean1 = context.getBean(Clock.class);
        Clock clockBean2 = context.getBean(Clock.class);
        Clock clockBean3 = context.getBean(Clock.class);
        Assertions.assertNotEquals(clockBean1, clockBean2);
        Assertions.assertNotEquals(clockBean2, clockBean3);
        Assertions.assertNotEquals(clockBean1, clockBean3);
    }
}