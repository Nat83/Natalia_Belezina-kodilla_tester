package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ForumStatsTestSuite {

    ForumStats forumStats;
    List<User> testUsers;

    @BeforeEach
    public void SetUp() {
        forumStats = new ForumStats();
        testUsers = new ArrayList<>();
        testUsers.add(new User("Walter White", 40, 7, "Chemists"));
        testUsers.add(new User("Micheal Jacson", 39, 45, "Chemist"));
        testUsers.add(new User("Alicia Keys", 50, 230, "Security"));
        testUsers.add(new User("Jessie Pinkman", 17, 4640, "Sales"));
        testUsers.add(new User("Tuco Salamanca", 15, 116, "Manager"));
        testUsers.add(new User("Gus Firing", 18, 0, "Board"));
        testUsers.add(new User("Gale Boetticher", 58, 2, "Chemists"));
        testUsers.add(new User("Fernando Santos", 17, 1, "Security"));
        testUsers.add(new User("Mike Ehrmantraut", 40, 20, "Security"));
        testUsers.add(new User("Tuco Salamanca", 16, 3, "Board"));
        testUsers.add(new User("Alice Cooper", 41, 70, "Chemists"));
        testUsers.add(new User("Leticia Silva", 17, 30, "Chemists"));
        testUsers.add(new User("Gonzalo Cabelo", 16, 20, "Security"));
    }

    @Test
    public void canDisplayAverageOfPostsForAdults() {
        double averageNumOfPostsAdults = forumStats.getAverageNumberOfPostForUsersOverOrEqualToAge(18, testUsers);

        assertEquals(53.428, averageNumOfPostsAdults, 0.008);
    }

    @Test
    public void canDisplayAverageOfPostsForMinors() {
        double averageNumOfPostsMinors = forumStats.averageNumberOfPostForUsersUnderAge(18, testUsers);

        assertEquals(801.666, averageNumOfPostsMinors, 0.006);
    }

    @Test
    public void canDisplayAverageOfPostsForPeopleOverOrEqual40() {
        double averageNumOfPostsForPeopleOverOrEqual40 =
                forumStats.getAverageNumberOfPostForUsersOverOrEqualToAge(40, testUsers);

        assertEquals(65.8, averageNumOfPostsForPeopleOverOrEqual40);
    }

    @Test
    public void canDisplayAverageOfPostsForPeopleUnder40() {
        double averageNumOfPostsForPeopleUnder40 = forumStats.averageNumberOfPostForUsersUnderAge(40, testUsers);

        assertEquals(606.875, averageNumOfPostsForPeopleUnder40);
    }
}