package com.kodilla.optional.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    Application application;

    @BeforeEach
    public void setUp() {
        application = new Application();

        application.students.add(new Student("Zosia Samosia", new Teacher("Alojzy Bombel")));
        application.students.add(new Student("Jacek Placek", null));
        application.students.add(new Student("Jan Kowalski", new Teacher("Baltazar Gabka")));
        application.students.add(new Student("Zenon Zenon", null));
        application.students.add(new Student("Krystyna Nowak", new Teacher("Mr Mussle")));
        application.students.add(new Student("Zuzanna Bania", null));
        application.students.add(new Student("Krystian Testowy", null));
        application.students.add(new Student("Ewka Konewka", new Teacher("Pan Kleks")));
    }

    @Test
    public void canReturnCorrectNumberOfAllStudents() {

        int numberOfStudents = application.displayStudentList().size();
        assertEquals(8, numberOfStudents);
    }

    @Test
    public void canDisplayCorrectStudentNames() {
        String student1 = application.displayStudentList().get(0).getName();
        String student2 = application.displayStudentList().get(1).getName();
        String student3 = application.displayStudentList().get(7).getName();

        assertEquals("Zosia Samosia", student1);
        assertEquals("Jacek Placek", student2);
        assertEquals("Ewka Konewka", student3);
    }

    @Test
    public void canDisplayNamesOfExistingTeachers() {

        List<String> namesOfTeachers = application.displayStudentList()
                .stream()
                .map(student -> student.getTeacher())
                .filter(t -> t != null)
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println("Students without teachers: " + namesOfTeachers);
        assertEquals("[Alojzy Bombel, Baltazar Gabka, Mr Mussle, Pan Kleks]", namesOfTeachers.toString());
    }

    @Test
    public void canDisplayNamesOfStudentsWithExistingTeachers() {

        List<String> namesOfStudents = application.displayStudentList()
                .stream()
                .filter(s -> s.getTeacher() != null)
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println("Students with assigned teachers: " + namesOfStudents);
        assertEquals("[Zosia Samosia, Jan Kowalski, Krystyna Nowak, Ewka Konewka]", namesOfStudents.toString());
    }

    @Test
    public void canDisplayNamesOfStudentsWithoutExistingTeachers() {

        List<String> namesOfStudents = application.displayStudentList()
                .stream()
                .filter(s -> s.getTeacher() == null)
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println("Students without teachers: " + namesOfStudents);
        assertEquals("[Jacek Placek, Zenon Zenon, Zuzanna Bania, Krystian Testowy]", namesOfStudents.toString());
    }
}