package com.harsh.sadp.student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(
                "Harsh",
                List.of(85.0, 90.0, 78.0, 87.0)
        );

        GradeCalculator calculator = new GradeCalculator();

        double average = calculator.calculateAverage(student);
        String grade = calculator.calculateGrade(student);

        StudentRepository repository =
                new StudentRepository(
                        Path.of("data", "students.txt"));

        System.out.println("Student Name: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Grade: " + grade);

        try {
            repository.save(student, average, grade);
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.err.println(
                    "Failed to save student data: " + e.getMessage());
        }
    }
}
