package com.kodilla.collections.adv.immutable.homework;

public class TaskApplication {

    public static void main(String[] args) {
        Task task = new Task("Do your homework ", 2);
        System.out.println("Task: " + task.title() + ", duration: " + task.duration());
    }

}
