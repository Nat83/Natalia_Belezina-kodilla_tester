import java.util.ArrayList;
import java.util.Collections;

public class RandomNumbers {

    public ArrayList<Integer> listOfRandomNumbers;

//    public static int getRandom(int max) {
//        return (int) (Math.random() * max);
//    }

    public ArrayList<Integer> generateRandomNumbersUntilExceedSum(int max, int maxsum) {
        int sum = 0;
        int randomNumber = (int) (Math.random() * max);
        this.listOfRandomNumbers= new ArrayList<Integer>();

        while (sum <= maxsum) {
            sum = sum + randomNumber;
            listOfRandomNumbers.add(randomNumber);
            randomNumber = (int) (Math.random() * max);
        }
        System.out.println("Random numbers from 0-" + max + " until their sum exceeds " + maxsum + " " +
                listOfRandomNumbers.toString());
        return listOfRandomNumbers;
    }

    public int getMaxRandomNumber(){

        int maxRandom = Collections.max(this.listOfRandomNumbers);

        System.out.println("Maximum number is :" + maxRandom);
        return maxRandom;
    }
    public int getMinRandomNumber(){

        int minRandom = Collections.min(this.listOfRandomNumbers);

        System.out.println("Minimum number is :" + minRandom);
        return minRandom;
    }
}
