package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {

    }

    private static AtomicInteger counter = new AtomicInteger(0);

    public static int splittingIntoThreads(int numberOfIncreases) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < numberOfIncreases; i++) {
                counter.incrementAndGet();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < numberOfIncreases; i++) {
                counter.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = counter.intValue();

        counter = new AtomicInteger(0);
        return result;
    }
}
