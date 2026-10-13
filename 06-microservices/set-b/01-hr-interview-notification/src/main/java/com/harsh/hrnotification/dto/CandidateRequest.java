package com.harsh.hrnotification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CandidateRequest(

        @NotBlank(message = "Candidate name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String candidateName,

        @NotBlank(message = "Candidate email is required")
        @Email(message = "Enter a valid email address")
        @Size(max = 254, message = "Email cannot exceed 254 characters")
        String email

) {
}