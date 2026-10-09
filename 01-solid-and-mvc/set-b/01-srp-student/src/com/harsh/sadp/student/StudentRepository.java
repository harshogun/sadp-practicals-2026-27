package com.harsh.sadp.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class StudentRepository {

    private final Path filePath;

    public StudentRepository(Path filePath) {
        this.filePath = filePath;
    }

    public void save(
            Student student,
            double average,
            String grade) throws IOException {

        String record = String.format(
                "%s | Marks: %s | Average: %.2f | Grade: %s%n",
                student.getName(),
                student.getMarks(),
                average,
                grade
        );

        Path parent = filePath.toAbsolutePath().getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }

        Files.writeString(
                filePath,
                record,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
