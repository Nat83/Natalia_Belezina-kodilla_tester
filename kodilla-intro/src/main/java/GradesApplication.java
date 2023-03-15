import java.util.Arrays;

public class GradesApplication {
    public static void main(String[] args) {

        Grades myGrades = new Grades();

        myGrades.add(4);
        myGrades.add(3);
        myGrades.add(6);
        myGrades.add(5);
        myGrades.add(3);
        myGrades.add(1);
        myGrades.add(5);
        myGrades.add(5);
        myGrades.add(5);
        myGrades.add(6);

        System.out.println("My grades are " + Arrays.toString(myGrades.returnGrades()));
        System.out.println("My last added grade is " + myGrades.returnLastAddedGrade());
        System.out.println("My average grade is " + myGrades.returnAverageGrade());
    }
}
