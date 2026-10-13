package com.harsh.erp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinancialEntry {
    private Long id;
    private String type;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Long saleId;

    public FinancialEntry() {}

    public FinancialEntry(Long id, String type, String description,
                          BigDecimal amount, LocalDate date,
                          Long saleId) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.saleId = saleId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Long getSaleId() { return saleId; }
    public void setSaleId(Long saleId) { this.saleId = saleId; }
}