import java.util.Arrays;

public class FirstClass {
    public static void main(String[] args) {

//        String myFirstStringText = "Hello from FirstClass!";
//        System.out.println(myFirstStringText);
//
//        Notebook notebook = new Notebook(600,1000, 2010);
//        System.out.println(notebook.weight + " " + notebook.price);
//        notebook.checkPrice();
//
//        Notebook heavyNotebook = new Notebook(2000, 1500,2020);
//        System.out.println(heavyNotebook.weight + " " + heavyNotebook.price);
//        heavyNotebook.checkPrice();
//
//        Notebook oldNotebook = new Notebook(1200, 500, 2023);
//        System.out.println(oldNotebook.weight + " " + oldNotebook.price);
//        oldNotebook.checkPrice();
//
//        notebook.checkPriceAndYear(2000,1981);

//        Grades myGrades = new Grades();
//
//        myGrades.add(4);
//        myGrades.add(3);
//        myGrades.add(6);
//        myGrades.add(5);
//        myGrades.add(3);
//        myGrades.add(1);
//        myGrades.add(5);
//        myGrades.add(5);
//        myGrades.add(5);
//        myGrades.add(6);
//
//
//        System.out.println("My grades are" + Arrays.toString(myGrades.grades));
//        System.out.println("My last added grade is " + myGrades.returnLastAddedGrade());
//        System.out.println("My average grade is " + myGrades.returnAverageGrade());

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.generateRandomNumbersUntilExceedSum(31,5000);
        randomNumbers.getMaxRandomNumber();
        randomNumbers.getMinRandomNumber();


        Application application = new Application();
        application.getInfoAboutUser("Natalia",40, 161);

        Book book = Book.of("Isaac Asimov", "The Galaxy");
        Book book2 = Book.of("Richardson Alan J.", "Dear Evil Tester");

    }
}
