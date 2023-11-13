package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.time.LocalDate;
import java.util.stream.Stream;

import static edu.hw5.Task2.*;

public class Task2Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task2Test.TestArgumentsProvider1.class)
    @DisplayName("Checking searchFriday13Th function efficiency")
    void testSearchFriday13Th(int year, String result) {
        assert(Task2.searchFriday13Th(year).toString().equals(result));
    }

    static class TestArgumentsProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(2015, "[2015-02-13, 2015-03-13, 2015-11-13]"),
                Arguments.of(2030, "[2030-09-13, 2030-12-13]"),
                Arguments.of(2012, "[2012-01-13, 2012-04-13, 2012-07-13]")
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task2Test.TestArgumentsProvider2.class)
    @DisplayName("Checking nextFriday13Th function efficiency")
    void testNextFriday13Th(LocalDate year, LocalDate result) {
        assert (nextFriday13Th(year).equals(result));
    }

    static class TestArgumentsProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13)),
                Arguments.of(LocalDate.of(1982, 11, 13), LocalDate.of(1983, 5, 13)),
                Arguments.of(LocalDate.of(2044, 10, 13), LocalDate.of(2045, 1, 13))
            );
        }
    }
}
