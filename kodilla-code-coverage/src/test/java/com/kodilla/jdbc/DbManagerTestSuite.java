package com.kodilla.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @Test
    void testConnect() {
        //Given
        //When
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }
    @Test
    void testSelectUsers() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertUsers(statement);

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 5;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    @Test
    void testSelectUsersPosts() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS U\n" +
                "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY U.ID\n" +
                "HAVING COUNT(*) >= 2;";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertPosts(statement);

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*)\n" +
                "FROM USERS U\n" +
                "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY U.ID\n" +
                "HAVING COUNT(*) >= 2;";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getPostsResultsCount(rs);
        int expected = count + 1;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private static final List<AbstractMap.SimpleEntry<Integer, String>> POSTS = List.of(
            new AbstractMap.SimpleEntry<>(2, "Bla Bla Bla"),
            new AbstractMap.SimpleEntry<>(4, "Test123"),
            new AbstractMap.SimpleEntry<>(4, "AAA"),
            new AbstractMap.SimpleEntry<>(3, "Hello"),
            new AbstractMap.SimpleEntry<>(1, "Good morning!")
    );
    private void insertPosts(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<Integer, String> post : POSTS) {
            statement.executeUpdate(
                    String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES ('%d', '%b')",
                            post.getKey(),
                            post.getValue()
                    )
            );
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while(rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }
    private static int getPostsResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while(rs.next()) {
            System.out.printf(" %s, %s%n",
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("COUNT(*)");
        }
        return count;
    }
}