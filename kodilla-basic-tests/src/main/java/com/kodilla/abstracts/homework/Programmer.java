package com.kodilla.abstracts.homework;

public class Programmer extends Job {

    @Override
    public void getResponsibilities() {
        System.out.println("Responsibilities of programmer are: planning, analysing, coding, testing, " +
                "debugging, fixing, deploying, maintaining code, cooperating with testers and other members of team");
    }
}