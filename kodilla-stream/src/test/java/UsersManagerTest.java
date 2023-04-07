import com.kodilla.stream.UsersManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersManagerTest {

    UsersManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UsersManager();
    }

    @Test
    public void returningCorrectNumberOfUserFromChemistGroup() {
        int numberOfUsersFromChemistGroup = UsersManager.filterChemistGroupUsernames().size();

        assertEquals(2, numberOfUsersFromChemistGroup);
    }

    @Test
    public void returningCorrectUserNamesFromChemistGroup() {
        String userFromChemistGroup1 = UsersManager.filterChemistGroupUsernames().get(0);
        String userFromChemistGroup2 = UsersManager.filterChemistGroupUsernames().get(1);

        assertEquals("Walter White", userFromChemistGroup1);
        assertEquals("Gale Boetticher", userFromChemistGroup2);
    }

    @Test
    public void returningCorrectNumberOfUsersOlderThan() {
        int numberOfUsersOlderThan = UsersManager.filterUsersOlderThan(40).size();

        assertEquals(4, numberOfUsersOlderThan);
    }

    @Test
    public void returningCorrectUsersOlderThan() {
        String user1 = UsersManager.filterUsersOlderThan(40).get(0);
        String user2 = UsersManager.filterUsersOlderThan(40).get(1);
        String user3 = UsersManager.filterUsersOlderThan(40).get(2);
        String user4 = UsersManager.filterUsersOlderThan(40).get(3);

        assertEquals("Walter White", user1);
        assertEquals("Gus Firing", user2);
        assertEquals("Gale Boetticher", user3);
        assertEquals("Mike Ehrmantraut", user4);
    }

    @Test
    public void returningCorrectNumberOfUsersWithPostNumberGraterThan() {
        int numberOfUsersWithPostNumber = UsersManager.filterUsersWithPostNumberGraterThan(90).size();

        assertEquals(2, numberOfUsersWithPostNumber);
    }

    @Test
    public void returningCorrectUsersWithPostNumberGraterThan() {
        String user1 = UsersManager.filterUsersWithPostNumberGraterThan(90).get(0);
        String user2 = UsersManager.filterUsersWithPostNumberGraterThan(90).get(1);

        assertEquals("Jessie Pinkman", user1);
        assertEquals("Tuco Salamanca", user2);
    }
}
