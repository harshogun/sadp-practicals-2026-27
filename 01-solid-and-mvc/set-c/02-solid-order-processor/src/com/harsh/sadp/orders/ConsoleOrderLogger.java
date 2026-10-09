package com.harsh.sadp.orders;

public class ConsoleOrderLogger implements OrderLogger {

    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
