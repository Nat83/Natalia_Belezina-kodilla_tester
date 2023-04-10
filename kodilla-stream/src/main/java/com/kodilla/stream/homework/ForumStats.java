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
        getAverageNumberOfPostForUsersOverOrEqualToAge(40, UsersRepository.getUsersList());
        averageNumberOfPostForUsersUnderAge(40, UsersRepository.getUsersList());

    }
    public static double getAverageNumberOfPostForUsersOverOrEqualToAge(int age, List<User> users){
        double averageNumberOfPostForOlderUsers = users
                .stream()
                .filter(user -> user.getAge()>=age)
                .mapToInt(user -> user.getNumberOfPost())
                .average()
                .getAsDouble();
        System.out.println(averageNumberOfPostForOlderUsers);
        return averageNumberOfPostForOlderUsers;

    }
    public static double averageNumberOfPostForUsersUnderAge(int age, List<User> users){

        double averageNumberOfPostForYoungerUsers = users
                .stream()
                .filter(user -> user.getAge()<age)
                .mapToInt(user -> user.getNumberOfPost())
                .average()
                .getAsDouble();
            System.out.println(averageNumberOfPostForYoungerUsers);
            return averageNumberOfPostForYoungerUsers;
    }
}
