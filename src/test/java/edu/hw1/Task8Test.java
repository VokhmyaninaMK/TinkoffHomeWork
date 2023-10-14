package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Тест программы 8")
    void knightBoardCapture() {

        //1 тест
        int [][] example1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        //2 тест
        int [][] example2 = {
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        //3 тест
        int [][] example3 = {
            {0, 0, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0, 0, 1}
        };

        //4 тест
        int [][] example4 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1}
        };

        //5 тест
        int [][] example5 = {
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1}
        };

        boolean[] answersArray = {
            Task8.knightBoardCapture(example1),
            Task8.knightBoardCapture(example2),
            Task8.knightBoardCapture(example3),
            Task8.knightBoardCapture(example4),
            Task8.knightBoardCapture(example5)
        };
        assertThat(answersArray).containsExactly(true, false, true, false, true);
    }
}
