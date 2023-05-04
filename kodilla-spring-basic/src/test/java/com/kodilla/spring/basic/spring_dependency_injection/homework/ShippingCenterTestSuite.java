package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class ShippingCenterTestSuite {
    @Test
    public void shouldSendPackageIfCorrectWeight() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        InPostParcelLockerDeliveryService bean = context.getBean(InPostParcelLockerDeliveryService.class);
        Boolean result = bean.deliverPackage("Ulanowskiego 14/9 54-678 Wrocław", 24);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotSendPackageIfTooBigWeight() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        InPostParcelLockerDeliveryService bean = context.getBean(InPostParcelLockerDeliveryService.class);
        Boolean result = bean.deliverPackage("Ulanowskiego 14/9 54-678 Wrocław", 26);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnCorrectNotificationIfPackageIsSend() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        ShippingCenter bean = context.getBean(ShippingCenter.class);
        String message = bean.sendPackage("Ulanowskiego 14/9 54-678 Wrocław", 24);
        Assertions.assertEquals("Package delivered to: Ulanowskiego 14/9 54-678 Wrocław", message);
    }

    @Test
    public void shouldReturnCorrectNotificationIfPackageIsNotSend() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        ShippingCenter bean = context.getBean(ShippingCenter.class);
        String message = bean.sendPackage("Ulanowskiego 14/9 54-678 Wrocław", 26);
        Assertions.assertEquals("Package not delivered to: Ulanowskiego 14/9 54-678 Wrocław", message);
    }
}