package com.harsh.sadp.student;

public class GradeCalculator {

    public double calculateAverage(Student student) {
        double total = 0;

        for (double mark : student.getMarks()) {
            total += mark;
        }

        return total / student.getMarks().size();
    }

    public String calculateGrade(Student student) {
        double average = calculateAverage(student);

        if (average >= 90) {
            return "A";
        } else if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}
