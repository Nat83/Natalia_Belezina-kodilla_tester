package com.kodilla.collections.sets.homework;

import com.kodilla.collections.sets.Order;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();
        stamps.add(new Stamp("London Zoo Bear", "20x30", true));
        stamps.add(new Stamp("London Zoo Fish", "20x30", false));
        stamps.add(new Stamp("Young Elisabeth the Second", "20x20", false));
        stamps.add(new Stamp("London Zoo Bear", "20x30", true));
        stamps.add(new Stamp("London Zoo Bear", "20x30", false));

        System.out.println(stamps.size());
        for (Stamp stamp : stamps)
            System.out.println(stamp);
    }
}
