package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Result {
    private Result() {

    }

    final static Logger LOGGER = LogManager.getLogger();
    private final static String MISSED = "Missed, mistake ";
    private final static String HIT = "Hit!\nThe word: ";
    private final static String OUT_OF = " out of ";
    private final static String THE_WORD = ".\nThe word: ";

    sealed interface GuessResult {
        char[] state();

        int attempt();

        int maxAttempts();

        @NotNull String message();

        record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {
            @Override
            @NotNull public String message() {
                return MISSED + attempt() + OUT_OF + String.valueOf(maxAttempts()) + THE_WORD
                    + new String(state()) + "\nYou lost!";
            }
        }

        record Win(char[] state, int attempt, int maxAttempts) implements GuessResult {
            @Override
            @NotNull public String message() {
                return HIT
                    + new String(state()) + "\nYou won!";
            }
        }

        record SuccessfulGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
            @Override
            @NotNull public String message() {
                return HIT
                    + new String(state()) + "\n";
            }
        }

        record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
            @Override
            @NotNull public String message() {
                return MISSED + String.valueOf(attempt()) + OUT_OF + String.valueOf(maxAttempts()) + THE_WORD
                    + new String(state()) + "\n";
            }
        }
    }
}
