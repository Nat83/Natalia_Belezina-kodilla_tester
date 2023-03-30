package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> schoolsWithPrincipal = new HashMap<>();

        Principal zofia = new Principal("Zofia", "Janicka");
        Principal dominika = new Principal("Dominika", "Dąb");
        Principal jozef = new Principal("Józef", "Dobrowolski");

        School zofiaSchool = new School("Chestnut School", Arrays.asList(26, 30, 30, 26, 34, 40, 18, 27));
        School dominikaSchool = new School("Primrose Hill School",
                Arrays.asList(33, 34, 23, 34, 35, 29, 28, 27, 32));
        School jozefSchool = new School("Camden Town School",
                Arrays.asList(26, 28, 34, 30, 28, 29, 29, 30, 32, 30, 32, 30));

        schoolsWithPrincipal.put(zofia, zofiaSchool);
        schoolsWithPrincipal.put(dominika, dominikaSchool);
        schoolsWithPrincipal.put(jozef, jozefSchool);

        for (Map.Entry<Principal, School> schoolEntry : schoolsWithPrincipal.entrySet()) {
            System.out.println(schoolEntry.getKey().getFirstname() + " " + schoolEntry.getKey().getLastname()
                    + " is  principle of: " + schoolEntry.getValue().getName() + " with total number of students - " +
                    schoolEntry.getValue().getSumOfStudent());
        }
    }
}