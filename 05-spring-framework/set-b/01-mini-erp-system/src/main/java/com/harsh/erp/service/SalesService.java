package com.harsh.erp.service;

import com.harsh.erp.dto.SaleRequest;
import com.harsh.erp.model.Product;
import com.harsh.erp.model.Sale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SalesService {

    private final Map<Long, Sale> sales = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    private final InventoryService inventoryService;
    private final FinanceService financeService;

    public SalesService(InventoryService inventoryService,
                        FinanceService financeService) {
        this.inventoryService = inventoryService;
        this.financeService = financeService;
    }

    public synchronized List<Sale> getAll() {
        return new ArrayList<>(sales.values());
    }

    @Transactional
    public synchronized Sale createSale(SaleRequest request) {
        Product product = inventoryService.getById(request.productId());

        if (product.getQuantity() < request.quantity()) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.CONFLICT,
                    "Insufficient stock");
        }

        BigDecimal total = product.getUnitPrice()
                .multiply(BigDecimal.valueOf(request.quantity()));

        // Deduct stock only after all request checks have passed.
        inventoryService.sell(product.getId(), request.quantity());

        Sale sale = new Sale(
                ids.incrementAndGet(),
                product.getId(),
                product.getName(),
                request.quantity(),
                total,
                LocalDate.now()
        );

        try {
            financeService.recordSaleIncome(sale);
            sales.put(sale.getId(), sale);
            return sale;
        } catch (RuntimeException exception) {
            inventoryService.restoreStock(product.getId(),
                    request.quantity());
            throw exception;
        }
    }
}