package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Checking clusterize function efficiency")
    void testClusterize() {
        ArrayList<String> ans1 = new ArrayList<>();
        ans1.add("((())())");
        ans1.add("(()(()()))");
        assertThat(edu.hw3.Task2.clusterize("((())())(()(()()))")).isEqualTo(ans1);

        ArrayList<String> ans2 = new ArrayList<>();
        ans2.add("((()))");
        ans2.add("(()())");
        assertThat(edu.hw3.Task2.clusterize("((()))(()())")).isEqualTo(ans2);

        ArrayList<String> ans3 = new ArrayList<>();
        ans3.add("(())");
        ans3.add("(()(()()))");
        ans3.add("()");
        assertThat(edu.hw3.Task2.clusterize("(())(()(()()))()")).isEqualTo(ans3);

        assertThat(edu.hw3.Task2.clusterize(")(")).isEqualTo(null);

        assertThat(edu.hw3.Task2.clusterize("())")).isEqualTo(null);
    }
}
