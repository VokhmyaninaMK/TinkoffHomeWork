package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Тест программы 4")
    void isNestable() {

        //1 тест
        String example1 = "eHll oowlr!d";

        //2 тест
        String example2 = "aHeva g oo dady";

        //3 тест
        String example3 = "badcd";

        //4 тест
        String example4 = "aAaAaA";

        String[] answersArray = {
            Task4.fixString(example1),
            Task4.fixString(example2),
            Task4.fixString(example3),
            Task4.fixString(example4)
        };
        assertThat(answersArray).containsExactly("Hello world!", "Have a good day", "abcdd", "AaAaAa");
    }
}
