package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Task7Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task7Test.TestArgumentsProvider1.class)
    @DisplayName("Checking firstRegEx function efficiency")
    void testFirstRegEx(String string, boolean result) {
        assert(Task7.firstRegEx(string)==result);
    }

    static class TestArgumentsProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("100000000", true),
                Arguments.of("101111", false),
                Arguments.of("11", false),
                Arguments.of("java", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task7Test.TestArgumentsProvider2.class)
    @DisplayName("Checking secondRegEx function efficiency")
    void testSecondRegEx(String string, boolean result) {
        assert(Task7.secondRegEx(string)==result);
    }

    static class TestArgumentsProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("0", true),
                Arguments.of("1", true),
                Arguments.of("000", true),
                Arguments.of("java", false),
                Arguments.of("1000000", false),
                Arguments.of("10001", true),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task7Test.TestArgumentsProvider3.class)
    @DisplayName("Checking thirdRegEx function efficiency")
    void testThirdRegEx(String string, boolean result) {
        assert(Task7.thirdRegEx(string)==result);
    }

    static class TestArgumentsProvider3 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("0", true),
                Arguments.of("101", true),
                Arguments.of("11", true),
                Arguments.of("10101", false),
                Arguments.of(null, false)
            );
        }
    }
}
