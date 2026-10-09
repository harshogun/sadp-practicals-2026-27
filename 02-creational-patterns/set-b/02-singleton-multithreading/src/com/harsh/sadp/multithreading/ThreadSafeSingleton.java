
package com.harsh.sadp.multithreading;

public class ThreadSafeSingleton {

    private ThreadSafeSingleton() {
        System.out.println("Singleton instance created.");
    }

    private static class Holder {
        private static final ThreadSafeSingleton INSTANCE =
                new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Singleton instance accessed.");
    }
}
