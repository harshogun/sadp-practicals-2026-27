package com.harsh.employee.service;

import com.harsh.employee.dto.EmployeeRequest;
import com.harsh.employee.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFileService {

    private final Path filePath;

    public EmployeeFileService(
            @Value("${app.employee-file:data/employees.csv}")
            String fileName) {
        this.filePath = Path.of(fileName)
                .toAbsolutePath()
                .normalize();
    }

    public synchronized Employee save(EmployeeRequest request) {
        List<Employee> employees = getAllInternal();

        boolean exists = employees.stream()
                .anyMatch(employee -> employee.getEno() == request.eno());

        if (exists) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Employee number already exists"
            );
        }

        Employee employee = new Employee(
                request.eno(),
                request.ename().trim(),
                request.designation().trim(),
                request.deptName().trim(),
                request.salary()
        );

        String record = String.join(
                "|",
                String.valueOf(employee.getEno()),
                employee.getEname(),
                employee.getDesignation(),
                employee.getDeptName(),
                employee.getSalary().toPlainString()
        ) + System.lineSeparator();

        try {
            Files.createDirectories(filePath.getParent());

            Files.writeString(
                    filePath,
                    record,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND
            );

            return employee;

        } catch (IOException exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not save employee to file",
                    exception
            );
        }
    }

    public synchronized List<Employee> getAll() {
        return getAllInternal();
    }

    public synchronized Employee getByEno(int eno) {
        return getAllInternal().stream()
                .filter(employee -> employee.getEno() == eno)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found"
                ));
    }

    private List<Employee> getAllInternal() {
        List<Employee> employees = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return employees;
        }

        try {
            for (String line : Files.readAllLines(
                    filePath, StandardCharsets.UTF_8)) {

                if (line.isBlank()) {
                    continue;
                }

                String[] fields = line.split("\\|", -1);

                if (fields.length != 5) {
                    throw new IOException(
                            "Invalid employee record in data file");
                }

                employees.add(new Employee(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        new BigDecimal(fields[4])
                ));
            }

            return employees;

        } catch (IOException | NumberFormatException exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not read employee data file",
                    exception
            );
        }
    }
}