package com.kodilla.spring.basic.dependency_injection.homework;

public class DHLDeliveryService implements DeliveryService {

    public boolean deliverPackage(String address, double weight) {
        if (weight > 40) {
            System.out.println("Package too heavy for DHL delivery man, sorry only pick up possible.");
            return false;
        }
        System.out.println("DHL is ready for delivering your order...");
        return true;
    }
}
