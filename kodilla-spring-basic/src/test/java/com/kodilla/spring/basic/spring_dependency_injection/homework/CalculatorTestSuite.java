package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class CalculatorTestSuite {

    @Test
    public void shouldDisplayCorrectMessageForCalculationResult() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Display bean = context.getBean(Display.class);
        String message = bean.display(5.44);
        Assertions.assertNotNull(message);
    }

    @Test
    public void shouldReturnCorrectValueResultForAddCalculation() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        Double result = bean.add(3.67, 3.40);
        Assertions.assertEquals(7.07, result, 0.01);
    }

    @Test
    public void shouldReturnCorrectValueResultForSubtractCalculation() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        Double result = bean.subtract(3.67, 3.40);
        Assertions.assertEquals(0.27, result, 0.01);
    }

    @Test
    public void shouldReturnCorrectValueResultForMultiplyCalculation() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        Double result = bean.multiply(3.67, 3.40);
        Assertions.assertEquals(12.48, result, 0.01);
    }

    @Test
    public void shouldReturnCorrectValueResultForDivideCalculation() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        Double result = bean.divide(3.67, 3.40);
        Assertions.assertEquals(1.08, result, 0.01);
    }
}