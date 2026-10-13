package com.harsh.erp.model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private String sku;
    private int quantity;
    private BigDecimal unitPrice;

    public Product() {}

    public Product(Long id, String name, String sku,
                   int quantity, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}