package com.kodilla.abstracts.homework;

public class PersonApplication {
    public static void main(String[] args) {
        Person person1 = new Person("Natalia", 40, "tester");
        Person person2 = new Person("Darek", 30, "programmer");
        Person person3 = new Person("Iza", 45, "project manager");

        person1.getPersonResponsibilities();
        person2.getPersonResponsibilities();
        person3.getPersonResponsibilities();
    }
}