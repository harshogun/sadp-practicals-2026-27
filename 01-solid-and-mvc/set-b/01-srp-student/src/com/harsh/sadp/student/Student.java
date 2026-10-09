package com.harsh.sadp.student;

import java.util.List;

public class Student {

    private final String name;
    private final List<Double> marks;

    public Student(String name, List<Double> marks) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Student name cannot be empty");
        }

        if (marks == null || marks.isEmpty()) {
            throw new IllegalArgumentException(
                    "Marks cannot be empty");
        }

        for (double mark : marks) {
            if (!Double.isFinite(mark) || mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                        "Each mark must be between 0 and 100");
            }
        }

        this.name = name;
        this.marks = List.copyOf(marks);
    }

    public String getName() {
        return name;
    }

    public List<Double> getMarks() {
        return marks;
    }
}
