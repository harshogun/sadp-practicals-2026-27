package com.harsh.erp.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Product name is required")
        @Size(max = 100)
        String name,

        @NotBlank(message = "SKU is required")
        @Size(max = 40)
        String sku,

        @Min(value = 0, message = "Stock cannot be negative")
        int quantity,

        @NotNull(message = "Unit price is required")
        @DecimalMin(value = "0.01",
                message = "Unit price must be greater than zero")
        BigDecimal unitPrice
) {}