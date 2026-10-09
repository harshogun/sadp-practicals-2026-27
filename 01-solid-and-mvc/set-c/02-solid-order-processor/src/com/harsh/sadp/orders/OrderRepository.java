package com.harsh.sadp.orders;

public interface OrderRepository {
    void save(Order order, double total);
}
