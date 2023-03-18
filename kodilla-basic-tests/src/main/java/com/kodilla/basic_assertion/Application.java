package com.kodilla.basic_assertion;

public class Application {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        double c = 3;
        double d = 2;

        Calculator calculator = new Calculator();
        Calculator calculator2 = new Calculator();
        Calculator calculator3 = new Calculator();

        int sumResult = calculator.sum(a, b);
        boolean correct = ResultChecker.assertEquals(13, sumResult);
        if (correct) {
            System.out.println("Metoda sum działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie działa poprawnie dla liczb " + a + " i " + b);
        }


        int subtractResult = calculator2.subtract(a, b);
        boolean correct2 = ResultChecker.assertEquals(-3, subtractResult);
        if (correct2) {
            System.out.println("Metoda subtract działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda subtract nie działa poprawnie dla liczb " + a + " i " + b);
        }


        double riseToPowerResult = calculator3.riseToPower(c, d);
        boolean correct3 = ResultChecker.assertEquals2(9, riseToPowerResult);
        if (correct3) {
            System.out.println("Metoda riseToPower działa poprawnie dla liczb " + c + " i " + d);
        } else {
            System.out.println("Metoda riseToPower nie działa poprawnie dla liczb " + c + " i " + d);
        }
    }
}
