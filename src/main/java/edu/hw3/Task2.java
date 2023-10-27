package edu.hw3;

import java.util.ArrayList;

public class Task2 {
    private Task2() {
    }

    static ArrayList<String> clusterize(String staples) {
        ArrayList<String> result = new ArrayList<>();
        char[] originalStaples = staples.toCharArray();
        int i = 0;
        int counter = 0;
        StringBuilder newBracketSequence = new StringBuilder();
        while (i < originalStaples.length) {
            while (i < originalStaples.length && originalStaples[i] == '(') {
                counter++;
                newBracketSequence.append(originalStaples[i]);
                i++;
            }
            while (i < originalStaples.length && originalStaples[i] == ')') {
                counter--;
                newBracketSequence.append(originalStaples[i]);
                i++;
            }
            if (counter == 0) {
                result.add(newBracketSequence.toString());
                newBracketSequence.delete(0, newBracketSequence.length());
            }
        }
        return result;
    }
}
