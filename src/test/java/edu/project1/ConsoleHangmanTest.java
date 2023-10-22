package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleHangmanTest {
    @Test
    @DisplayName(value = "Check Give Up")
    void testGiveUp() {
        Session sessionGiveUp = new Session("a", 1);
        Result.GuessResult guess = ConsoleHangman.tryGuess(sessionGiveUp, "Give up");
        assert(guess.getClass() == Result.GuessResult.Defeat.class);
    }
}
