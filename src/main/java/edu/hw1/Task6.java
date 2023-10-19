package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_CONST = 6174;

    public static int countK(int inputValue) {
        if (inputValue == KAPREKAR_CONST) {
            return 0;
        } else {
            char[] greaterSortedNumbers = Integer.toString(inputValue).toCharArray();
            Arrays.sort(greaterSortedNumbers);
            char[] lowerSortedNumbers = Integer.toString(inputValue).toCharArray();
            Arrays.sort(lowerSortedNumbers);
            for (int index = 0; index < lowerSortedNumbers.length / 2; index++) {
                char currentValue = greaterSortedNumbers[index];
                lowerSortedNumbers[index] = lowerSortedNumbers[lowerSortedNumbers.length - index - 1];
                lowerSortedNumbers[lowerSortedNumbers.length - index - 1] = currentValue;
            }
            int newValue =
                Integer.parseInt(new String(lowerSortedNumbers)) - Integer.parseInt(new String(greaterSortedNumbers));
            return 1 + countK(newValue);
        }
    }
}
