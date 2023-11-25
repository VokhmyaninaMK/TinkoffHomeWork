package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.splittingIntoThreads;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Checking  splittingIntoThreads function efficiency")
    void testSplittingIntoThreads() {

        assertThat(splittingIntoThreads(10)).isEqualTo(20);
        assertThat(splittingIntoThreads(100)).isEqualTo(200);
        assertThat(splittingIntoThreads(15)).isEqualTo(30);
        assertThat(splittingIntoThreads(0)).isEqualTo(0);
    }
}
