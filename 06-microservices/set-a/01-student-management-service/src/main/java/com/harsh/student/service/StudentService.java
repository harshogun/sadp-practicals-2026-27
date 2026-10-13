package com.harsh.student.service;

import com.harsh.student.dto.StudentRequest;
import com.harsh.student.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final Map<Long, Student> students =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    public StudentService() {
        create(new StudentRequest(
                "Amit Sharma",
                "amit@example.com",
                "Computer Science",
                22
        ));

        create(new StudentRequest(
                "Priya Patil",
                "priya@example.com",
                "Information Technology",
                23
        ));
    }

    public synchronized List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    public synchronized Student getById(Long id) {
        Student student = students.get(id);

        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found");
        }

        return student;
    }

    public synchronized Student create(StudentRequest request) {
        ensureEmailAvailable(request.email(), null);

        Student student = new Student(
                idGenerator.incrementAndGet(),
                request.name().trim(),
                request.email().trim(),
                request.course().trim(),
                request.age()
        );

        students.put(student.getId(), student);
        return student;
    }

    public synchronized Student update(
            Long id, StudentRequest request) {

        Student existing = getById(id);
        ensureEmailAvailable(request.email(), id);

        existing.setName(request.name().trim());
        existing.setEmail(request.email().trim());
        existing.setCourse(request.course().trim());
        existing.setAge(request.age());

        return existing;
    }

    public synchronized void delete(Long id) {
        if (students.remove(id) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found");
        }
    }

    private void ensureEmailAvailable(String email, Long excludeId) {
        boolean duplicate = students.values().stream()
                .anyMatch(student ->
                        student.getEmail().equalsIgnoreCase(email.trim())
                                && !student.getId().equals(excludeId));

        if (duplicate) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "A student with this email already exists");
        }
    }
}