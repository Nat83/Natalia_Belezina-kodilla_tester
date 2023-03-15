import java.util.ArrayList;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        User zofia = new User("Zofia", 11);
        User hania = new User("Hania", 13);
        User jan = new User("Jan", 39);
        User natalia = new User("Natalia", 40);
        User julia = new User("Julia", 23);
        User damian = new User("Damian", 43);

        User[] users = {zofia, hania, jan, natalia, julia, damian};

        int sumAges = 0;
        for (int i = 0; i < users.length; i++) {
            sumAges = sumAges + users[i].getAge();
        }

        System.out.println("Sum of users ages is " + sumAges);
        double averageAge = sumAges / users.length;
        System.out.println("Average age of users is " + averageAge);

        ArrayList<String> userNames = new ArrayList<String>();

        for (int i = 0; i < users.length; i++) {
            if (users[i].getAge() < averageAge) {
                userNames.add(users[i].getName());
            }
        }
        System.out.println("Users names with age below average are: " + userNames.toString());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
