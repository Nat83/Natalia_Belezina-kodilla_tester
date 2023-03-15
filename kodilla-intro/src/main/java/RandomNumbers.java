import java.util.Random;

public class RandomNumbers {
    int max = 0;
    int min = 31;

    public void generateRandomNumbersUntilExceedSum() {

        Random random = new Random();
        int sum = 0;

        while (sum <= 500) {
            int randomNumber = random.nextInt(31);
            setMaxRandomNumber(randomNumber);
            setMinRandomNumber(randomNumber);

            System.out.println(randomNumber);
            System.out.println("Currently maximum random number is: " + getMaxRandomNumber());
            System.out.println("Currently minimum random number is: " + getMinRandomNumber());

            sum = sum + randomNumber;
        }
        System.out.println("Sum of random numbers already exceeded 500");
    }

    public int getMaxRandomNumber() {
        return max;
    }

    public int getMinRandomNumber() {
        return min;
    }

    public int setMaxRandomNumber(int randomNumber) {
        if (randomNumber > max) {
            max = randomNumber;
        }
        return max;
    }

    public int setMinRandomNumber(int randomNumber) {
        if (randomNumber < min) {
            min = randomNumber;
        }
        return min;
    }

    // Moje pierwsze podejście do zadania:

//    public ArrayList<Integer> listOfRandomNumbers;

//    public static int getRandom(int max) {
//        return (int) (Math.random() * max);
//    }

//    public ArrayList<Integer> generateRandomNumbersUntilExceedSum(int max, int maxsum) {
//        int sum = 0;
//        int randomNumber = (int) (Math.random() * max);
//        this.listOfRandomNumbers= new ArrayList<Integer>();
//
//        while (sum <= maxsum) {
//            sum = sum + randomNumber;
//            listOfRandomNumbers.add(randomNumber);
//            randomNumber = (int) (Math.random() * max);
//        }
//        System.out.println("Random numbers from 0-" + max + " until their sum exceeds " + maxsum + " " +
//                listOfRandomNumbers.toString());
//        return listOfRandomNumbers;
//    }
//
//    public int getMaxRandomNumber(){
//
//        int maxRandom = Collections.max(this.listOfRandomNumbers);
//
//        System.out.println("Maximum number is :" + maxRandom);
//        return maxRandom;
//    }
//    public int getMinRandomNumber(){
//
//        int minRandom = Collections.min(this.listOfRandomNumbers);
//
//        System.out.println("Minimum number is :" + minRandom);
//        return minRandom;
//    }
}
