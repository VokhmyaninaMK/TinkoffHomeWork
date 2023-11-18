package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {
    @Test
    @DisplayName(value = "Checking randomWord and randomInt function efficiency")

    void testRandomWordAndInt(){
        for (int attempt = 0; attempt < 200; attempt++) {
            randomWordAndInt();
        }
    }

    void randomWordAndInt(){
        Dictionary dictionary = new Dictionary();
        String randomWord = dictionary.randomWord();
        int randomInt = dictionary.randomInt();
        boolean correctWord = !randomWord.isEmpty() && !randomWord.equals(null);
        assert(correctWord);
        assert(randomInt > 0);
    }
}
