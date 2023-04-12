package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;

import java.util.List;


public class ForumStats {

    List<User> users;

    public ForumStats() {
        this.users = UsersRepository.getUsersList();
    }

    public static void main(String[] args) {
        System.out.println(getAverageNumberOfPostForUsersOverOrEqualToAge(40, UsersRepository.getUsersList()));
        System.out.println(averageNumberOfPostForUsersUnderAge(40, UsersRepository.getUsersList()));
    }

    public static double getAverageNumberOfPostForUsersOverOrEqualToAge(int age, List<User> users) {
        return users
                .stream()
                .filter(user -> user.getAge() >= age)
                .mapToInt(user -> user.getNumberOfPost())
                .average()
                .getAsDouble();
    }

    public static double averageNumberOfPostForUsersUnderAge(int age, List<User> users) {

        return users
                .stream()
                .filter(user -> user.getAge() < age)
                .mapToInt(user -> user.getNumberOfPost())
                .average()
                .getAsDouble();
    }
}
