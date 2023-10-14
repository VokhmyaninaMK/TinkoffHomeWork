package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String stringWithMistakes) {

        char[] lettersArray = stringWithMistakes.toCharArray();
        for (int index = 0; index < lettersArray.length - 1; index += 2) {
            char current = lettersArray[index];
            lettersArray[index] = lettersArray[index + 1];
            lettersArray[index + 1] = current;
        }
        return new String(lettersArray);
    }
}

