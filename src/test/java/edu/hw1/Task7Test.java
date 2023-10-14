package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Тест программы 7")
    void RotateRightLeft() {

        //1 тест
        int example1Number = 8;
        int example1Digits = 1;

        //2 тест
        int example2Number = -9;
        int example2Digits = 3;

        //3 тест
        int example3Number = 16;
        int example3Digits = 1;

        //4 тест
        int example4Number = 19;
        int example4Digits = 2;

        int[] answersArray = {
            Task7.rotateRight(example1Number, example1Digits),
            Task7.rotateRight(example2Number, example2Digits),
            Task7.rotateLeft(example3Number, example3Digits),
            Task7.rotateLeft(example4Number, example4Digits)
        };
        assertThat(answersArray).containsExactly(4, -1, 1, 14);
    }
}
