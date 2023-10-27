package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    private Task4() {
    }

    private static final int BASE = 10;
    private static final int ONE = 1;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int FIFTY = 50;
    private static final int ONE_HUNDRED = 100;
    private static final int FIVE_HUNDRED = 500;
    private static final int ONE_THOUSAND = 1000;

    static String convertToRoman(int number) {
        Map<Integer, String> romanSings = new HashMap<>();
        romanSings.put(ONE, "I");
        romanSings.put(FIVE, "V");
        romanSings.put(TEN, "X");
        romanSings.put(FIFTY, "L");
        romanSings.put(ONE_HUNDRED, "C");
        romanSings.put(FIVE_HUNDRED, "D");
        romanSings.put(ONE_THOUSAND, "M");

        final int[] keys = {1, 5, 10, 50, 100, 500, 1000};
        StringBuilder result = new StringBuilder();

        int originalNumber = number;
        int digit = 1;
        while (originalNumber > 0) {
            int current = originalNumber % BASE * digit;
            int i = 0;
            int suitableNumber = 0;
            StringBuilder currentRomanNumber = new StringBuilder();
            while (i < keys.length && keys[i] <= current) {
                suitableNumber = keys[i];
                i++;
            }
            if (suitableNumber == current) {
                currentRomanNumber = new StringBuilder(romanSings.get(current) + currentRomanNumber);
            } else if (suitableNumber != ONE_THOUSAND && (keys[i] - current) / digit == 1) {
                suitableNumber = keys[i];
                currentRomanNumber =
                    new StringBuilder(romanSings.get(digit) + romanSings.get(suitableNumber) + currentRomanNumber);
            } else {
                currentRomanNumber = new StringBuilder(romanSings.get(suitableNumber) + currentRomanNumber);
                for (int j = 0; j < (current - suitableNumber) / digit; j++) {
                    currentRomanNumber = new StringBuilder(currentRomanNumber + romanSings.get(digit));
                }
            }
            result = new StringBuilder(currentRomanNumber.toString() + result);
            originalNumber /= BASE;
            digit *= BASE;
        }
        return result.toString();
    }
}
