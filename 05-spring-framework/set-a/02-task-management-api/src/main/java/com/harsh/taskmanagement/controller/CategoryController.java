package com.harsh.taskmanagement.controller;

import com.harsh.taskmanagement.model.Category;
import com.harsh.taskmanagement.service.CategoryService;
import com.harsh.taskmanagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final TaskService taskService;

    public CategoryController(
            CategoryService categoryService,
            TaskService taskService
    ) {
        this.categoryService = categoryService;
        this.taskService = taskService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id)
                .orElseThrow(() -> new org.springframework.web.server
                        .ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody Category category
    ) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(
                id,
                taskService.hasTasksInCategory(id)
        );
    }
}