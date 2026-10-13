package com.harsh.erp.controller;

import com.harsh.erp.dto.FinanceRequest;
import com.harsh.erp.model.FinancialEntry;
import com.harsh.erp.service.FinanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping("/entries")
    public List<FinancialEntry> getEntries() {
        return financeService.getAll();
    }

    @PostMapping("/expenses")
    public FinancialEntry recordExpense(
            @Valid @RequestBody FinanceRequest request) {
        return financeService.recordExpense(request);
    }

    @GetMapping("/balance")
    public Map<String, BigDecimal> getBalance() {
        return Map.of("balance", financeService.getBalance());
    }
}