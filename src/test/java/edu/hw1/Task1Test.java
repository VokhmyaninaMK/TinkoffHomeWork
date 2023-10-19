package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Перевод минут в секунды")
    void testMinutesToSeconds() {
        //позитивные тесты
        String example1 = "00:00";
        String example2 = "01:03";

        //негативные тесты
        String example3 = "10:111";
        String example4 = "05:60";
        String example5 = "11:00:00";
        String example6 = "-13:00";
        String example7 = "ups:ups";

        Long[] answersArrayPositive = {
            Task1.minutesToSeconds(example1),
            Task1.minutesToSeconds(example2)
        };

        assertThat(answersArrayPositive).containsExactly(0L, 63L);

        Long[] answersArrayNegative = {
            Task1.minutesToSeconds(example3),
            Task1.minutesToSeconds(example4),
            Task1.minutesToSeconds(example5),
            Task1.minutesToSeconds(example6),
            Task1.minutesToSeconds(example7)
        };

        assertThat(answersArrayNegative).containsExactly(-1L, -1L, -1L, -1L, -1L);
    }
}
