
public class LeapYear {

    public static void main(String[] args) {
        isLeapYear(1009);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 & year % 100 != 0){
            System.out.println("It is leap year");
            return true;}
        else {
            System.out.println("It is normal year");
            return false;}
    }
}

