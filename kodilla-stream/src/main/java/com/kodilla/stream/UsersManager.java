package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println(chemistGroupUsernames);
        List<String> olderUsersList = filterUsersOlderThan(40);
        System.out.println(olderUsersList);
        List<String> usersWithNumberOfPostGraterThan = filterUsersWithPostNumberGraterThan(90);
        System.out.println(usersWithNumberOfPostGraterThan);
    }

    public static List<String> filterChemistGroupUsernames() {
        List<String> usernames = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return usernames;
    }

    public static List<String> filterUsersOlderThan(int age) {
        List<String> olderUsers = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > age)
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return olderUsers;
    }

    public static List<String> filterUsersWithPostNumberGraterThan(int numberOfPost) {
        List<String> usersWithNumberOfPostGraterThan = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > numberOfPost)
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return usersWithNumberOfPostGraterThan;
    }

    public static String getUserName(User user) {
        return user.getUsername();
    }
}
