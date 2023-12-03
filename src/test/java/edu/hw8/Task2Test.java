package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Local fixedThreadPool check")
    void testLocalFixedThreadPool() throws Exception {
        FixedThreadPool fixedThreadPool = new FixedThreadPool();
        fixedThreadPool.create(6);

        List<Integer> fibNumbers = new ArrayList<>(Collections.nCopies(15, -1));

        List<Thread> threads = IntStream.range(0, 15).mapToObj(element -> new Thread(() -> {
            if (element == 0 || element == 1) {
                fibNumbers.set(element, 1);
            } else {
                while (fibNumbers.get(element - 1) == -1 || fibNumbers.get(element - 2) == -1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                fibNumbers.set(element, fibNumbers.get(element - 1) + fibNumbers.get(element - 2));
            }

        })).toList();

        for (Thread thread : threads) {
            fixedThreadPool.execute(thread);
        }

        fixedThreadPool.start();

        while (fibNumbers.get(14) == -1) {
            Thread.sleep(10);
        }

        fixedThreadPool.close();

        assertThat(fibNumbers.toArray()).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610);
    }
}
