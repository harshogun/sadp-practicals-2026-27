package com.harsh.inventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "Product name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "SKU is required")
        @Size(max = 40)
        @Pattern(
                regexp = "^[A-Za-z0-9_-]+$",
                message = "SKU can contain letters, numbers, _ and - only"
        )
        String sku,

        @NotBlank(message = "Category is required")
        @Size(max = 60)
        String category,

        @Min(value = 0, message = "Quantity cannot be negative")
        int quantity,

        @NotNull(message = "Price is required")
        @DecimalMin(
                value = "0.01",
                message = "Price must be greater than zero"
        )
        BigDecimal price

) {
}