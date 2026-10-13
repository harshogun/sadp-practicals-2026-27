package com.harsh.taskmanagement.service;

import com.harsh.taskmanagement.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryService {

    private final Map<Long, Category> categories = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public CategoryService() {
        create(new Category(null, "Study", "Academic and learning tasks"));
        create(new Category(null, "Work", "Professional tasks"));
        create(new Category(null, "Personal", "Personal tasks"));
    }

    public List<Category> getAll() {
        return new ArrayList<>(categories.values());
    }

    public Optional<Category> getById(Long id) {
        return Optional.ofNullable(categories.get(id));
    }

    public Category create(Category category) {
        long id = idGenerator.incrementAndGet();
        category.setId(id);
        categories.put(id, category);
        return category;
    }

    public Category update(Long id, Category updatedCategory) {
        if (!categories.containsKey(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Category not found");
        }

        updatedCategory.setId(id);
        categories.put(id, updatedCategory);
        return updatedCategory;
    }

    public void delete(Long id, boolean hasTasks) {
        if (!categories.containsKey(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Category not found");
        }

        if (hasTasks) {
            throw new ResponseStatusException(
                    CONFLICT,
                    "Cannot delete a category that is assigned to tasks"
            );
        }

        categories.remove(id);
    }

    public void ensureExists(Long id) {
        if (!categories.containsKey(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Category not found");
        }
    }
}