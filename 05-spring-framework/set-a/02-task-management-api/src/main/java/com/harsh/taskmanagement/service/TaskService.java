package com.harsh.taskmanagement.service;

import com.harsh.taskmanagement.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    private final CategoryService categoryService;

    public TaskService(CategoryService categoryService) {
        this.categoryService = categoryService;

        create(new Task(
                null,
                "Complete SADP practical",
                "Finish the Spring Framework practical",
                false,
                java.time.LocalDate.now().plusDays(3),
                1L
        ));

        create(new Task(
                null,
                "Revise Spring Boot",
                "Review REST APIs and dependency injection",
                false,
                java.time.LocalDate.now().plusDays(5),
                1L
        ));
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> getById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public List<Task> getByCategory(Long categoryId) {
        categoryService.ensureExists(categoryId);

        return tasks.values().stream()
                .filter(task -> categoryId.equals(task.getCategoryId()))
                .toList();
    }

    public Task create(Task task) {
        validateCategory(task.getCategoryId());

        long id = idGenerator.incrementAndGet();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public Task update(Long id, Task updatedTask) {
        if (!tasks.containsKey(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Task not found");
        }

        validateCategory(updatedTask.getCategoryId());

        updatedTask.setId(id);
        tasks.put(id, updatedTask);
        return updatedTask;
    }

    public void delete(Long id) {
        if (tasks.remove(id) == null) {
            throw new ResponseStatusException(NOT_FOUND, "Task not found");
        }
    }

    public boolean hasTasksInCategory(Long categoryId) {
        return tasks.values().stream()
                .anyMatch(task -> categoryId.equals(task.getCategoryId()));
    }

    private void validateCategory(Long categoryId) {
        if (categoryId != null) {
            categoryService.ensureExists(categoryId);
        }
    }
}