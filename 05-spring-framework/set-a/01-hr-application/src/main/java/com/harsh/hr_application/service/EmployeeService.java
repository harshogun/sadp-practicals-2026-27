
package com.harsh.hr_application.service;


import com.harsh.hr_application.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public EmployeeService() {
        employees.add(new Employee(
                idGenerator.getAndIncrement(),
                "Amit Shah",
                "amit@example.com",
                "IT",
                45000
        ));

        employees.add(new Employee(
                idGenerator.getAndIncrement(),
                "Narendra Modi",
                "Modi@example.com",
                "HR",
                40000
        ));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(idGenerator.getAndIncrement());
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = getEmployeeById(id);

        if (existing == null) {
            return null;
        }

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setSalary(updated.getSalary());

        return existing;
    }

    public boolean deleteEmployee(Long id) {
        return employees.removeIf(
                employee -> employee.getId().equals(id)
        );
    }
}
