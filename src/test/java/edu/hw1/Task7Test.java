package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Битовый сдвиг вправо или влево")
    void testRotateRightLeft() {

        //1 тест позитивный
        int example1Number = 8;
        int example1Digits = 1;

        //2 тест позитивный
        int example2Number = 19;
        int example2Digits = 2;

        //3 тест позитивный
        int example3Number = 16;
        int example3Digits = 1;

        //4 тест негативный
        int example4Number = -9;
        int example4Digits = 3;

        int[] answersArrayPositive = {
            Task7.rotateRight(example1Number, example1Digits),
            Task7.rotateLeft(example2Number, example2Digits),
            Task7.rotateLeft(example3Number, example3Digits)
        };
        assertThat(answersArrayPositive).containsExactly(4, 14, 1);

        int[] answersArrayNegative = {
            Task7.rotateLeft(example4Number, example4Digits)
        };
        assertThat(answersArrayNegative).containsExactly(-1);
    }
}
