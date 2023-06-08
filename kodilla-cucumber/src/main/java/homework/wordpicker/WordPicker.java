package homework.wordpicker;

import java.time.MonthDay;

public class WordPicker {

    public static String returnCorrectWord(int chosenNumber) {
        String result;
        if(isNumberDivisible(chosenNumber,3)){
            result = "Fizz";
    }else if(isNumberDivisible(chosenNumber,5)) {
            result ="Buzz";
        }
    else if((isNumberDivisible(chosenNumber,5))&&(isNumberDivisible(chosenNumber,3))) {
            result ="FizzBuzz";
        }
    else {
        result = "None";
        }return result;
    }

    public static boolean isNumberDivisible(int chosenNumber, int divider) {
        return chosenNumber % divider==0;
    }
}
