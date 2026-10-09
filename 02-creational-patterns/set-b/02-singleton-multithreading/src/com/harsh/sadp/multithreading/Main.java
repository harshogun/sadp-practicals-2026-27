
package com.harsh.sadp.multithreading;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        Runnable task = () -> {
            ThreadSafeSingleton instance =
                    ThreadSafeSingleton.getInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> Instance ID: "
                            + System.identityHashCode(instance)
            );
        };

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task, "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
