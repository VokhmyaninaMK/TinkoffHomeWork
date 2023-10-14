package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Тест программы 1")
    void testMinutesToSeconds() {
        String example1 = "00:00";
        String example2 = "01:03";
        String example3 = "10:111";
        String example4 = "05:60";
        String example5 = "11:00:00";
        String example6 = "-13:00";

        Long[] answersArray = {
            Task1.minutesToSeconds(example1),
            Task1.minutesToSeconds(example2),
            Task1.minutesToSeconds(example3),
            Task1.minutesToSeconds(example4),
            Task1.minutesToSeconds(example5),
            Task1.minutesToSeconds(example6)
        };
        assertThat(answersArray).containsExactly(0L, 63L, -1L, -1L, -1L, -1L);
    }
}
