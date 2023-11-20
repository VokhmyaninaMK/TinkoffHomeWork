package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanTest {
    @Test
    @DisplayName(value = "Check Give Up")
    void testGiveUp() {
        Session sessionGiveUp = new Session("a", 1);
        Result.GuessResult guess1 = ConsoleHangman.tryGuess(sessionGiveUp, "Give up");
        assert (guess1.getClass() == Result.GuessResult.Defeat.class);
        assertThat(guess1.message()).isEqualTo("Missed, mistake 0 out of 1.\nThe word: *\nYou lost!");

        Session sessionWin = new Session("a", 2);
        Result.GuessResult guess2 = ConsoleHangman.tryGuess(sessionWin, "a");
        assert (guess2.getClass() == Result.GuessResult.Win.class);
        assertThat(guess2.message()).isEqualTo("Hit!\nThe word: a\nYou won!");

        Session sessionDefeat = new Session("a", 1);
        Result.GuessResult guess3 = ConsoleHangman.tryGuess(sessionDefeat, "b");
        assert (guess3.getClass() == Result.GuessResult.Defeat.class);
        assertThat(guess3.message()).isEqualTo("Missed, mistake 1 out of 1.\nThe word: *\nYou lost!");

        Session sessionSuccessfulGuess = new Session("abcd", 2);
        Result.GuessResult guess4 = ConsoleHangman.tryGuess(sessionSuccessfulGuess, "a");
        assert (guess4.getClass() == Result.GuessResult.SuccessfulGuess.class);
        assertThat(guess4.message()).isEqualTo("Hit!\nThe word: a***\n");

        Session sessionFailedGuess = new Session("abcd", 2);
        Result.GuessResult guess5 = ConsoleHangman.tryGuess(sessionFailedGuess, "f");
        assert (guess5.getClass() == Result.GuessResult.FailedGuess.class);
        assertThat(guess5.message()).isEqualTo("Missed, mistake 1 out of 2.\nThe word: ****\n");
    }
}
