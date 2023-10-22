package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Checking CallingInfo function efficiency")
    void testCallingInfo() {
        assertThat(Task4.callingInfo().className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(Task4.callingInfo().methodName()).isEqualTo("testCallingInfo");
    }
}
