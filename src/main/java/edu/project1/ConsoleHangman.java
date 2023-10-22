package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import static edu.project1.Main.LOGGER;

class ConsoleHangman {
    private final static String GIVE_UP = "Give up";

    Dictionary dc = new Dictionary();
    String answer = dc.randomWord();
    int maxAttempts = dc.randomInt();
    Session session = new Session(answer, new char[answer.length()], maxAttempts, 0);

    public void run() {
        Arrays.fill(session.userAnswer, '*');
        do {
            LOGGER.info("Guess a letter:\n");
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            if (input.length() == 1 || input.equals(GIVE_UP)) {
                printState(tryGuess(this.session, input));
            }
        } while (this.session.play);
    }

    private Main.GuessResult tryGuess(Session session, String input) {
        if (input.equals(GIVE_UP)) {
            session.play = false;
            return new Main.GuessResult.Defeat(session.userAnswer, session.attempts, session.maxAttempts);
        }
        return session.guess(input.charAt(0));
    }

    private void printState(Main.GuessResult guess) {
        LOGGER.info(guess.message());
    }
}
