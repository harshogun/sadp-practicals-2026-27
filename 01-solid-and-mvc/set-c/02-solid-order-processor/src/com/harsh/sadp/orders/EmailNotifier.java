package com.harsh.sadp.orders;

public interface EmailNotifier {
    void sendConfirmation(Order order, double total);
}
