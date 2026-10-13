package com.harsh.departmentemployee.service;

import com.harsh.departmentemployee.model.Employee;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class EmployeeDirectoryService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>(
            List.of(
                    new Employee(1L, "Amit Sharma",
                            "amit@example.com", "IT",
                            new BigDecimal("55000.00")),

                    new Employee(2L, "Priya Patil",
                            "priya@example.com", "HR",
                            new BigDecimal("48000.00")),

                    new Employee(3L, "Rahul More",
                            "rahul@example.com", "IT",
                            new BigDecimal("62000.00")),

                    new Employee(4L, "Sneha Kulkarni",
                            "sneha@example.com", "Finance",
                            new BigDecimal("58000.00")),

                    new Employee(5L, "Neha Joshi",
                            "neha@example.com", "Sales",
                            new BigDecimal("45000.00"))
            )
    );

    public List<Employee> getAllEmployees() {
        return List.copyOf(employees);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        String requestedDepartment = department.trim()
                .toLowerCase(Locale.ROOT);

        return employees.stream()
                .filter(employee -> employee.getDepartment()
                        .toLowerCase(Locale.ROOT)
                        .equals(requestedDepartment))
                .toList();
    }
}