package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Тест программы 6")
    void countK() {

        //1 тест
        int example1 = 8431;

        //2 тест
        int example2 = 6174;

        //3 тест
        int example3 = 6147;

        //4 тест
        int example4 = 4513;


        int[] answersArray = {
            Task6.countK(example1),
            Task6.countK(example2),
            Task6.countK(example3),
            Task6.countK(example4)
        };
        assertThat(answersArray).containsExactly(3, 0, 1, 7);
    }
}
