package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    static <T> Map<T, Integer> freqDict(ArrayList<T> originalArray) {
        Map<T, Integer> result = new HashMap<>();
        for (T t : originalArray) {
            result.merge(t, 1, Integer::sum);
        }
        return result;
    }
}
