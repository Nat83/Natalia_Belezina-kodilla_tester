package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Date;
import java.util.List;

class DbManagerTestSuite {
    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );
    static List<AbstractMap.SimpleEntry<Integer, String>> POSTS;
    static List<AbstractMap.SimpleEntry<String, String>> USERS2;
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
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

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

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

    @Test
    void selectUsersAndPosts() throws SQLException {
        //Given (checking real number of users with at least 2 posts)
        String sqlQuery = "SELECT COUNT(*), U.ID, U.FIRSTNAME, U.LASTNAME\n" +
                "FROM USERS U\n" +
                "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY U.ID\n" +
                "HAVING COUNT(*) >= 2;";
        Statement postsStatement = createStatement();
        postsStatement.executeQuery(sqlQuery);
        ResultSet rs = postsStatement.executeQuery(sqlQuery);
        int numberOfUsersWithAtLeastTwoPostsBeforeAddingUserAndPosts = getRowsCount(rs);

        //When (adding new user with unique surname who has 2 posts)
        String UserQuery = "SELECT * FROM USERS ORDER BY ID DESC LIMIT 1";
        Statement userStmt = dbManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        insertUnicUser(userStmt, String.format("TestSurname_%s",
                new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date())));
        ResultSet rs2 = userStmt.executeQuery(UserQuery);
        rs2.next();
        insertPosts(userStmt, rs2.getInt("ID"));

        //Then (verifying that number of users with at least two post increased by 1)
        String UsersQuery = "SELECT * FROM USERS";
        Statement usersStmt = dbManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        ResultSet rs3 = usersStmt.executeQuery(UsersQuery);
        rs3.next();
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
            int expected = numberOfUsersWithAtLeastTwoPostsBeforeAddingUserAndPosts + 1;
            Assertions.assertEquals(expected, counter);

        }
    }

    private void insertUnicUser(Statement statement, String Surname) throws SQLException {
        USERS2 = List.of(
                new AbstractMap.SimpleEntry<>("TestName", Surname)
        );

        for (AbstractMap.SimpleEntry<String, String> user : USERS2) {
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private void insertPosts(Statement statement, Integer userID) throws SQLException {
        POSTS = List.of(
                new AbstractMap.SimpleEntry<>(userID, "Post nr 1"),
                new AbstractMap.SimpleEntry<>(userID, "Post nr 2")
        );
        for (AbstractMap.SimpleEntry<Integer, String> post : POSTS) {
            statement.executeUpdate(
                    String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES ('%d', '%s')",
                            post.getKey(),
                            post.getValue()
                    )
            );
        }
    }
}

