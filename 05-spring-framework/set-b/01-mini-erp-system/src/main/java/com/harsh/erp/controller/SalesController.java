package com.harsh.erp.controller;

import com.harsh.erp.dto.SaleRequest;
import com.harsh.erp.model.Sale;
import com.harsh.erp.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sale> getSales() {
        return salesService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale createSale(@Valid @RequestBody SaleRequest request) {
        return salesService.createSale(request);
    }
}