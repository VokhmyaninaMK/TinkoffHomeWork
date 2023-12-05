package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.factorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Checking factorial function efficiency")
    void testFactorial() {

        assertThat(factorial(1)).isEqualTo(1);
        assertThat(factorial(5)).isEqualTo(120);
        assertThat(factorial(4)).isEqualTo(24);
        assertThat(factorial(0)).isEqualTo(1);
    }
}
