package com.harsh.employee.controller;

import com.harsh.employee.dto.EmployeeRequest;
import com.harsh.employee.model.Employee;
import com.harsh.employee.service.EmployeeFileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeFileService employeeFileService;

    public EmployeeController(EmployeeFileService employeeFileService) {
        this.employeeFileService = employeeFileService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(
            @Valid @RequestBody EmployeeRequest request) {
        return employeeFileService.save(request);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeFileService.getAll();
    }

    @GetMapping("/{eno}")
    public Employee getEmployeeByEno(@PathVariable int eno) {
        return employeeFileService.getByEno(eno);
    }
}