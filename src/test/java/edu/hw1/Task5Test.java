package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Тест программы 5")
    void isNestable() {

        //1 тест
        String example1 = "11302210";

        //2 тест
        String example2 = "12211120";

        //3 тест
        String example3 = "11211230";

        //4 тест
        String example4 = "51012100";

        //5 тест
        String example5 = "62017011";

        boolean[] answersArray = {
            Task5.palindromeDescendant(example1),
            Task5.palindromeDescendant(example2),
            Task5.palindromeDescendant(example3),
            Task5.palindromeDescendant(example4),
            Task5.palindromeDescendant(example5)
        };
        assertThat(answersArray).containsExactly(true, false, true, false, true);
    }
}
