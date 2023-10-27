package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Testing Backward Iterator")
    void testBackwardIterator() {

        Task8.BackwardIterator<Integer> backwardIterator = new Task8.BackwardIterator<>(List.of(1, 2, 3));

        ArrayList<Integer> test = new ArrayList<>();

        while (backwardIterator.hasNext()) {
            test.add(backwardIterator.next());
        }

        assertThat(test.get(0)).isEqualTo(3);
        assertThat(test.get(1)).isEqualTo(2);
        assertThat(test.get(2)).isEqualTo(1);

    }
}
