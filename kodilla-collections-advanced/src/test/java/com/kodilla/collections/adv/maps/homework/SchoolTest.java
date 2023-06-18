package com.kodilla.collections.adv.maps.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SchoolTest {

    School zofiaSchool;
    School dominikaSchool;
    School jozefSchool;

    @Test
    void shouldReturnSumOfStudents(){
        //Given
        Map<Principal, School> schoolsWithPrincipal = new HashMap<>();

        Principal zofia = new Principal("Zofia", "Janicka");
        Principal dominika = new Principal("Dominika", "Dąb");
        Principal jozef = new Principal("Józef", "Dobrowolski");

        zofiaSchool = new School("Chestnut School", Arrays.asList(26, 30, 30, 26, 34, 40, 18, 27));
        dominikaSchool = new School("Primrose Hill School",
                Arrays.asList(33, 34, 23, 34, 35, 29, 28, 27, 32));
        jozefSchool = new School("Camden Town School",
                Arrays.asList(26, 28, 34, 30, 28, 29, 29, 30, 32, 30, 32, 30));

        schoolsWithPrincipal.put(zofia, zofiaSchool);
        schoolsWithPrincipal.put(dominika, dominikaSchool);
        schoolsWithPrincipal.put(jozef, jozefSchool);

        //When
        int expected1 = zofiaSchool.getSumOfStudent();
        int expected2 = dominikaSchool.getSumOfStudent();
        int expected3 = jozefSchool.getSumOfStudent();

        //Then
        Assertions.assertEquals(expected1,231);
        Assertions.assertEquals(expected2,275);
        Assertions.assertEquals(expected3,358);
    }
}