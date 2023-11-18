package edu.project1;

import org.jetbrains.annotations.NotNull;

class Dictionary {
    final static int MULTIPLIER = 10;
    final static String[] DICTIONARY =
        new String[] {"age", "room", "orange", "sunshine", "pineapple", "peach", "rabbit", "car", "flower", "plum"};
    final static int[] ATTEMPTS = new int[] {1, 2, 3, 4, 5, 6, 7};

    @NotNull String randomWord() {
        return DICTIONARY[(int) (Math.random() * MULTIPLIER) % DICTIONARY.length];
    }

    int randomInt() {
        return ATTEMPTS[(int) (Math.random() * MULTIPLIER) % ATTEMPTS.length];
    }
}
