package edu.project1;

import java.util.Scanner;
import static edu.project1.Result.LOGGER;

class ConsoleHangman {
    private final static String GIVE_UP = "Give up";

    Dictionary dc = new Dictionary();
    String answer = dc.randomWord();
    int maxAttempts = dc.randomInt();
    Session session = new Session(answer, maxAttempts);

    public void run() {

        do {
            LOGGER.info("Guess a letter:\n");
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            if (input.length() == 1 || input.equals(GIVE_UP)) {
                printState(tryGuess(this.session, input));
            }
        } while (this.session.play);
    }

    public static Result.GuessResult tryGuess(Session session, String input) {
        if (input.equals(GIVE_UP)) {
            session.play = false;
            return new Result.GuessResult.Defeat(session.userAnswer, session.attempts, session.maxAttempts);
        }
        return session.guess(input.charAt(0));
    }

    private void printState(Result.GuessResult guess) {
        LOGGER.info(guess.message());
    }
}
