package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SessionTest {
    @Test
    @DisplayName(value = "Check Session work")
    void testWin() {
        Session sessionWin = new Session("a", 1);
        Result.GuessResult guess1 = sessionWin.guess('a');
        assert (guess1.getClass() == Result.GuessResult.Win.class);
        assertThat(guess1.message()).isEqualTo("Hit!\nThe word: a\nYou won!");

        Session sessionDefeat = new Session("aa", 1);
        Result.GuessResult guess2 = sessionDefeat.guess('b');
        assert (guess2.getClass() == Result.GuessResult.Defeat.class);
        assertThat(guess2.message()).isEqualTo("Missed, mistake 1 out of 1.\nThe word: **\nYou lost!");

        Session sessionSuccessfulGuess = new Session("abbb", 2);
        Result.GuessResult guess3 = sessionSuccessfulGuess.guess('a');
        assert (guess3.getClass() == Result.GuessResult.SuccessfulGuess.class);
        assertThat(guess3.message()).isEqualTo("Hit!\nThe word: a***\n");

        Session sessionFailedGuess = new Session("abbb", 2);
        Result.GuessResult guess4 = sessionFailedGuess.guess('f');
        assert (guess4.getClass() == Result.GuessResult.FailedGuess.class);
        assertThat(guess4.message()).isEqualTo("Missed, mistake 1 out of 2.\nThe word: ****\n");
    }
}
