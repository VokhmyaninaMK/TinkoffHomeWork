package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Тест программы 3")
    void isNestable() {
        //1 тест
        long[] nestableArray1 = {1, 2, 3};
        long[] expandableArray1 = {0, 7, 13};

        //2 тест
        long[] nestableArray2 = {0, 5, 8, 10};
        long[] expandableArray2 = {};

        //3 тест
        long[] nestableArray3 = {};
        long[] expandableArray3 = {7, 40, 50};

        //4 тест
        long[] nestableArray4 = {0, 30, 23};
        long[] expandableArray4 = {11, 45};

        boolean[] answersArray = {
            Task3.isNestable(nestableArray1, expandableArray1),
            Task3.isNestable(nestableArray2, expandableArray2),
            Task3.isNestable(nestableArray3, expandableArray3),
            Task3.isNestable(nestableArray4, expandableArray4)
        };
        assertThat(answersArray).containsExactly(true, false, false, false);
    }
}
