package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Может ли первый массив быть вложен во второй")
    void testIsNestable() {
        //1 тест позитивный
        long[] nestableArray1 = {1, 2, 3};
        long[] expandableArray1 = {0, 7, 13};

        //2 тест негативный
        long[] nestableArray2 = {0, 5, 8, 10};
        long[] expandableArray2 = {};

        //3 тест негативный
        long[] nestableArray3 = {};
        long[] expandableArray3 = {7, 40, 50};

        //4 тест негаивный
        long[] nestableArray4 = {0, 30, 23};
        long[] expandableArray4 = {11, 45};

        boolean[] answersArrayPositive = {
            Task3.isNestable(nestableArray1, expandableArray1)
        };
        assertThat(answersArrayPositive).containsExactly(true);

        boolean[] answersArrayNegative = {
            Task3.isNestable(nestableArray2, expandableArray2),
            Task3.isNestable(nestableArray3, expandableArray3),
            Task3.isNestable(nestableArray4, expandableArray4)
        };
        assertThat(answersArrayNegative).containsExactly(false, false, false);
    }
}
