package com.kodilla.collections.adv.maps.homework;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Integer> numbersOfStudentInClasses = new ArrayList<>();


    public School(String name, List<Integer> numbersOfStudentInClasses) {
        this.name = name;
        this.numbersOfStudentInClasses = numbersOfStudentInClasses;
    }

    public int getSumOfStudent() {
        int sum = 0;
        for (int studentInClass : numbersOfStudentInClasses)
            sum = sum + studentInClass;
        return sum;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNumbersOfStudentInClasses() {
        return numbersOfStudentInClasses;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", numbersOfStudentInClasses=" + numbersOfStudentInClasses +
                '}';
    }
}