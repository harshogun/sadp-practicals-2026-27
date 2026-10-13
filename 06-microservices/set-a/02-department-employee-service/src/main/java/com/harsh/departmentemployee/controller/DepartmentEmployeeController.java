package com.harsh.departmentemployee.controller;

import com.harsh.departmentemployee.model.Employee;
import com.harsh.departmentemployee.service.EmployeeDirectoryService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class DepartmentEmployeeController {

    private final EmployeeDirectoryService employeeDirectoryService;

    public DepartmentEmployeeController(
            EmployeeDirectoryService employeeDirectoryService) {
        this.employeeDirectoryService = employeeDirectoryService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDirectoryService.getAllEmployees();
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable
            @NotBlank(message = "Department is required")
            @Size(max = 60, message = "Department is too long")
            String department) {

        return employeeDirectoryService
                .getEmployeesByDepartment(department);
    }
}