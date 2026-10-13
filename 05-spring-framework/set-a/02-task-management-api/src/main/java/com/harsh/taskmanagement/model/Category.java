package com.harsh.taskmanagement.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Category {

    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(max = 60, message = "Category name cannot exceed 60 characters")
    private String name;

    @Size(max = 250, message = "Description cannot exceed 250 characters")
    private String description;

    public Category() {
    }

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}