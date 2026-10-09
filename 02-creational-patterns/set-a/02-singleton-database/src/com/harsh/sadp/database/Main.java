
package com.harsh.sadp.database;

public class Main {

    public static void main(String[] args) {

//        DatabaseConnection connection1 =
//                DatabaseConnection.getConnection();
//
//        DatabaseConnection connection2 =
//                DatabaseConnection.getConnection();
//
//        System.out.println(
//                "Same instance: " + (connection1 == connection2)
//        );
//
//        connection1.connect();
//        connection2.connect();


        Runnable task = () -> {
            DatabaseConnection connection =
                    DatabaseConnection.getConnection();

            System.out.println(
                    Thread.currentThread().getName()
                            + " received instance: "
                            + System.identityHashCode(connection)
            );
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

    }
}
