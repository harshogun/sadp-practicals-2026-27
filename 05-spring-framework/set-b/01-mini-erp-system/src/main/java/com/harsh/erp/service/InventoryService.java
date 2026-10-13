package com.harsh.erp.service;

import com.harsh.erp.dto.ProductRequest;
import com.harsh.erp.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InventoryService {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    public InventoryService() {
        create(new ProductRequest("Keyboard", "KB-001", 20,
                new BigDecimal("799.00")));
        create(new ProductRequest("Mouse", "MS-001", 30,
                new BigDecimal("399.00")));
        create(new ProductRequest("Monitor", "MN-001", 10,
                new BigDecimal("8999.00")));
    }

    public synchronized List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public synchronized Product getById(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found");
        }
        return product;
    }

    public synchronized Product create(ProductRequest request) {
        ensureSkuAvailable(request.sku(), null);

        Product product = new Product(
                ids.incrementAndGet(),
                request.name().trim(),
                request.sku().trim(),
                request.quantity(),
                request.unitPrice()
        );

        products.put(product.getId(), product);
        return product;
    }

    public synchronized Product update(Long id, ProductRequest request) {
        Product existing = getById(id);
        ensureSkuAvailable(request.sku(), id);

        existing.setName(request.name().trim());
        existing.setSku(request.sku().trim());
        existing.setQuantity(request.quantity());
        existing.setUnitPrice(request.unitPrice());

        return existing;
    }

    public synchronized void delete(Long id) {
        if (products.remove(id) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    public synchronized Product sell(Long id, int quantity) {
        Product product = getById(id);

        if (product.getQuantity() < quantity) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Insufficient stock");
        }

        product.setQuantity(product.getQuantity() - quantity);
        return product;
    }

    public synchronized void restoreStock(Long id, int quantity) {
        Product product = getById(id);
        product.setQuantity(product.getQuantity() + quantity);
    }

    private void ensureSkuAvailable(String sku, Long excludeId) {
        boolean duplicate = products.values().stream()
                .anyMatch(p -> p.getSku().equalsIgnoreCase(sku.trim())
                        && !p.getId().equals(excludeId));

        if (duplicate) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "SKU already exists");
        }
    }
}