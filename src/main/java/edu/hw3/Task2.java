package edu.hw3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Task2 {
    private Task2() {
    }

    static ArrayList<String> clusterize(String staples) {
        if (!checkingSequence(staples)) {
            return null;
        }
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

    private static boolean checkingSequence(String staples) {
        Deque<Character> maybeCorrectSequence = new ArrayDeque<>();
        int i = 0;
        while (i < staples.length()) {
            if (staples.charAt(i) == '(') {
                maybeCorrectSequence.add('(');
            } else if (staples.charAt(i) == ')' && !maybeCorrectSequence.isEmpty()) {
                maybeCorrectSequence.removeLast();
            } else {
                return false;
            }
            i++;
        }
        return true;
    }
}
