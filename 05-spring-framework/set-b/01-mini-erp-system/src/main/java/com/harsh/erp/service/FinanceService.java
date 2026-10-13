package com.harsh.erp.service;

import com.harsh.erp.dto.FinanceRequest;
import com.harsh.erp.model.FinancialEntry;
import com.harsh.erp.model.Sale;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FinanceService {

    private final Map<Long, FinancialEntry> entries =
            new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    public synchronized FinancialEntry recordExpense(FinanceRequest request) {
        FinancialEntry entry = new FinancialEntry(
                ids.incrementAndGet(),
                "EXPENSE",
                request.description().trim(),
                request.amount(),
                LocalDate.now(),
                null
        );

        entries.put(entry.getId(), entry);
        return entry;
    }

    public synchronized FinancialEntry recordSaleIncome(Sale sale) {
        FinancialEntry entry = new FinancialEntry(
                ids.incrementAndGet(),
                "INCOME",
                "Sale of " + sale.getProductName(),
                sale.getTotalAmount(),
                sale.getSaleDate(),
                sale.getId()
        );

        entries.put(entry.getId(), entry);
        return entry;
    }

    public synchronized List<FinancialEntry> getAll() {
        return new ArrayList<>(entries.values());
    }

    public synchronized BigDecimal getBalance() {
        BigDecimal income = entries.values().stream()
                .filter(e -> "INCOME".equals(e.getType()))
                .map(FinancialEntry::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expenses = entries.values().stream()
                .filter(e -> "EXPENSE".equals(e.getType()))
                .map(FinancialEntry::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return income.subtract(expenses);
    }
}