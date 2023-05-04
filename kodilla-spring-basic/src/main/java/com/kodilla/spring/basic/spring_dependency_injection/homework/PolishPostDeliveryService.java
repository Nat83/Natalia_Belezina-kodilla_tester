package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.stereotype.Component;

@Component
public class PolishPostDeliveryService implements DeliveryService {
    public boolean deliverPackage(String address, double weight) {
        if (weight > 20) {
            System.out.println("Package too heavy to deliverer to your door. You need to pick it up from nearest" +
                    "post office.");
            return false;
        }
        System.out.println("Delivering in progress...");
        return true;
    }
}
