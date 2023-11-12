package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

class Session {
    private final String answer;
    final char[] userAnswer;
    final int maxAttempts;
    int attempts;
    boolean play = true;

    Session(String answer, char[] userAnswer, int maxAttempts, int attempts) {
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.maxAttempts = maxAttempts;
        this.attempts = attempts;
    }

    @NotNull Main.GuessResult guess(char guess) {
        if (answer.contains(Character.toString(guess))) {
            for (int i = 0; i < userAnswer.length; i++) {
                if (answer.charAt(i) == guess) {
                    userAnswer[i] = guess;
                }
            }
        } else {
            attempts++;
        }
        if (attempts == maxAttempts) {
            this.play = false;
            return new Main.GuessResult.Defeat(userAnswer, attempts, maxAttempts);
        }
        if (!Arrays.toString(userAnswer).contains("*")) {
            this.play = false;
            return new Main.GuessResult.Win(userAnswer, attempts, maxAttempts);
        }
        if (Arrays.toString(userAnswer).contains(Character.toString(guess))) {
            return new Main.GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }
        return new Main.GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
    }

    @NotNull Main.GuessResult giveUp() {
        this.play = false;
        return new Main.GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }
}

