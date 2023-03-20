package com.kodilla.abstracts.homework;

public class Person {
    private final String firstName;
    private final int age;
    private final String job;

    public Person(String firstName, int age, String job) {
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public void getPersonResponsibilities() {
        Tester tester = new Tester();
        Programmer programmer = new Programmer();
        ProjectManager projectManager = new ProjectManager();

        if (this.job == "tester") {
            tester.getResponsibilities();
        } else if (this.job == "programmer") {
            programmer.getResponsibilities();
        } else if (this.job == "project manager") {
            projectManager.getResponsibilities();
        } else {
            System.out.println("There is no such job specified");
        }
    }
}