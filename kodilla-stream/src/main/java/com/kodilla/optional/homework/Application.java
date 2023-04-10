package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Application {
    public List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        application.students.add(new Student("Zosia Samosia", new Teacher("Alojzy Bombel")));
        application.students.add(new Student("Jacek Placek", null));
        application.students.add(new Student("Jan Kowalski", new Teacher("Baltazar Gabka")));
        application.students.add(new Student("Zenon Zenon", null));
        application.students.add(new Student("Krystyna Nowak", new Teacher("Mr Mussle")));

        System.out.println(application.displayStudentList());
    }

    public List<Student> displayStudentList() {

        for (Student student : students) {
            Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
            String teacherName = optionalTeacher.orElse(new Teacher("<undefined>")).getName();
            System.out.println("Student: " + student.getName() + ",Teacher: " + teacherName);
        }
        return students;
    }
}

