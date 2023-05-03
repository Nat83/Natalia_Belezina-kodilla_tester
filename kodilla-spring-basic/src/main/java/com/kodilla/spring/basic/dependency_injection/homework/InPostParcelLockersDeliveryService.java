package com.kodilla.spring.basic.dependency_injection.homework;

public class InPostParcelLockersDeliveryService implements DeliveryService {

    public boolean deliverPackage(String address, double weight) {
        if (weight > 25) {
            System.out.println("Package too heavy for parcel locker");
            return false;
        }
        System.out.println("Good news from Inpost - delivering in progress, soon your parcel will arrive to " +
                "provided parcel locker address.");
        return true;
    }
}
