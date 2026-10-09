
package com.harsh.sadp.logger;

import java.time.LocalDateTime;

public class LoggerService {

    private static final LoggerService instance =
            new LoggerService();

    private LoggerService() {
        System.out.println("LoggerService initialized.");
    }

    public static LoggerService getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println(
                "[" + LocalDateTime.now() + "] " + message
        );
    }
}
