package com.harsh.erp.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record FinanceRequest(
        @NotBlank(message = "Type is required")
        @Pattern(regexp = "EXPENSE",
                flags = Pattern.Flag.CASE_INSENSITIVE,
                message = "Manual entries must be EXPENSE")
        String type,

        @NotBlank(message = "Description is required")
        @Size(max = 200)
        String description,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01",
                message = "Amount must be greater than zero")
        BigDecimal amount
) {}