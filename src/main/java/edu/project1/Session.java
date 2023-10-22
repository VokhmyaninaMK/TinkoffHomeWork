package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

class Session {
    private final String answer;
    final char[] userAnswer;
    final int maxAttempts;
    int attempts;
    boolean play = true;

    Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    @NotNull Result.GuessResult guess(char guess) {
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
            return new Result.GuessResult.Defeat(userAnswer, attempts, maxAttempts);
        }
        if (!Arrays.toString(userAnswer).contains("*")) {
            this.play = false;
            return new Result.GuessResult.Win(userAnswer, attempts, maxAttempts);
        }
        if (Arrays.toString(userAnswer).contains(Character.toString(guess))) {
            return new Result.GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }
        return new Result.GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
    }

    @NotNull Result.GuessResult giveUp() {
        this.play = false;
        return new Result.GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }
}
