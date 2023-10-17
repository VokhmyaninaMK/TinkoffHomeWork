package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Подсчет разрядов в числе")
    void testCountDigits() {
        int example1 = 10;
        int example2 = 0;
        int example3 = 1111;
        int example4 = -115;

        int[] answersArray = {
            Task2.countDigits(example1),
            Task2.countDigits(example2),
            Task2.countDigits(example3),
            Task2.countDigits(example4)
        };
        assertThat(answersArray).containsExactly(2, 1, 4, 3);
    }
}
