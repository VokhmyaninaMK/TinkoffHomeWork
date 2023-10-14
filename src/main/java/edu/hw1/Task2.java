package edu.hw1;

public class Task2 {
    private Task2() {
    }

    private static final int BASE = 10;

    public static int countDigits(int initialValue) {
        int unsignedIitialValue = Math.abs(initialValue);
        int answer = 1;
        while (Math.abs(unsignedIitialValue) > 1) {
            answer++;
            unsignedIitialValue /= BASE;
        }
        return answer;
    }
}

