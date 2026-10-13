package com.harsh.erp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {
    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal totalAmount;
    private LocalDate saleDate;

    public Sale() {}

    public Sale(Long id, Long productId, String productName,
                int quantity, BigDecimal totalAmount,
                LocalDate saleDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getSaleDate() { return saleDate; }
    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}