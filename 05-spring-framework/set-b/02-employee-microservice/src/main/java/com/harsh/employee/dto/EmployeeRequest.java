package com.harsh.employee.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record EmployeeRequest(

        @Positive(message = "Employee number must be positive")
        int eno,

        @NotBlank(message = "Employee name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        @Pattern(
                regexp = "^[^|\\r\\n]+$",
                message = "Name cannot contain pipe or newline characters"
        )
        String ename,

        @NotBlank(message = "Designation is required")
        @Size(max = 80)
        @Pattern(
                regexp = "^[^|\\r\\n]+$",
                message = "Designation cannot contain pipe or newline characters"
        )
        String designation,

        @NotBlank(message = "Department name is required")
        @Size(max = 80)
        @Pattern(
                regexp = "^[^|\\r\\n]+$",
                message = "Department cannot contain pipe or newline characters"
        )
        String deptName,

        @NotNull(message = "Salary is required")
        @DecimalMin(
                value = "0.01",
                message = "Salary must be greater than zero"
        )
        BigDecimal salary

) {
}