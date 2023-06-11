public class LeapYear {

    public static void main(String[] args) {
        isLeapYear(1423433436);
    }

    private static boolean isLeapYear(int year) {
        if (year < 1582) {
            System.out.println("The concept of a leap year did not exist yet!");
            return false;
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("It is leap year");
            return true;
        } else {
            System.out.println("It is normal year");
            return false;
        }
    }
}

