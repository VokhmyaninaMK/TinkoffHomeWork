package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Можно ли из числа сделать палиндром")
    void testPalindromeDescendant() {

        //1 тест позитивный
        String example1 = "11302210";

        //2 тест позитивный
        String example2 = "11211230";

        //3 тест позитивный
        String example3 = "62017011";

        //4 тест негативный
        String example4 = "12211120";

        //5 тест негативный
        String example5 = "51012100";

        boolean[] answersArrayPositive = {
            Task5.palindromeDescendant(example1),
            Task5.palindromeDescendant(example2),
            Task5.palindromeDescendant(example3)
        };
        assertThat(answersArrayPositive).containsExactly(true, true, true);

        boolean[] answersArrayNegative = {
            Task5.palindromeDescendant(example4),
            Task5.palindromeDescendant(example5)
        };
        assertThat(answersArrayNegative).containsExactly( false, false);
    }
}
