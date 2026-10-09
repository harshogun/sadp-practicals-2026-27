
package com.harsh.sadp.database;

public class DatabaseConnection {

    private DatabaseConnection() {
        System.out.println("DatabaseConnection instance created.");
    }

    private static class Holder {
        private static final DatabaseConnection INSTANCE =
                new DatabaseConnection();
    }

    public static DatabaseConnection getConnection() {
        return Holder.INSTANCE;
    }

    public void connect() {
        System.out.println("Connected using the shared instance.");
    }
}
