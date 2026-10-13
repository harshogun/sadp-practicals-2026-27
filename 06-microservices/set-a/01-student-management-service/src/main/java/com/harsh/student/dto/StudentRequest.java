package com.harsh.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record StudentRequest(

        @NotBlank(message = "Student name is required")
        @Size(max = 100)
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email address")
        String email,

        @NotBlank(message = "Course is required")
        @Size(max = 100)
        String course,

        @Positive(message = "Age must be positive")
        @Min(value = 16, message = "Student must be at least 16")
        int age

) {
}