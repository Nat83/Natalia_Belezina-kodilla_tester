import java.util.Random;

public class Loops {

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        String[] names = new String[] {"Anna", "Monika", "Jan", "Lucjan", "Dominika"};

        // Displaying names starting from the beginning of the table
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        //Displaying names starting from the end of the table
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }

        //Loop while
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    //Method to sum numbers from the table
    public int sumNumbersFromTable(int[] numbers){
        int result = 0;
        for (int i=0; i < numbers.length; i++ ){
            result = result + numbers[i];
        }
        return result;
    }
    //method returns the number of draws of numbers from 0 to 9 whose sum does not exceed the max value.
    public int getCountOfRandomNumber(int max) {
        Random random = new Random();
        int result = 0;
        int sum = 0;
        while (sum < max) {
            int temp = random.nextInt(10);
            sum = sum + temp;
            result++;
        }
        return result;
    }
}
