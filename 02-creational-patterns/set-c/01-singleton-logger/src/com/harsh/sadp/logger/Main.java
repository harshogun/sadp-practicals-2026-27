
package com.harsh.sadp.logger;

public class Main {

    public static void main(String[] args) {

        LoggerService logger1 = LoggerService.getInstance();
        LoggerService logger2 = LoggerService.getInstance();

        logger1.log("Application started.");
        logger2.log("User logged in.");

        System.out.println(
                "Same instance: " + (logger1 == logger2)
        );
    }
}
