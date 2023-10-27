package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Checking FreqDict function efficiency")
    void testFreqDict() {
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(1);
        test1.add(3);
        assertThat(edu.hw3.Task3.freqDict(test1).toString()).isEqualTo("{1=2, 2=1, 3=1}");

        ArrayList<String> test2 = new ArrayList<>();
        test2.add("this");
        test2.add("and");
        test2.add("that");
        test2.add("and");
        assertThat(edu.hw3.Task3.freqDict(test2).toString()).isEqualTo("{that=1, and=2, this=1}");

        ArrayList<String> test3 = new ArrayList<>();
        test3.add("a");
        test3.add("bb");
        test3.add("a");
        test3.add("bb");
        assertThat(edu.hw3.Task3.freqDict(test3).toString()).isEqualTo("{bb=2, a=2}");

        ArrayList<String> test4 = new ArrayList<>();
        test4.add("feature");
        test4.add("feature");
        test4.add("feature");
        test4.add("bug");
        test4.add("bug");
        assertThat(edu.hw3.Task3.freqDict(test4).toString()).isEqualTo("{feature=3, bug=2}");
    }
}
