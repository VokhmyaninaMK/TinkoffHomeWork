package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Task8Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider1.class)
    @DisplayName("Checking oddLengthRegEx function efficiency")
    void testOddLengthRegEx(String string, boolean result) {
        assert (Task8.oddLengthRegEx(string) == result);
    }

    static class TestArgumentsProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("1", true),
                Arguments.of("111111", false),
                Arguments.of("00", false),
                Arguments.of("java", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider2.class)
    @DisplayName("Checking zeroWithOddLenOrOneWithEvenLenRegEx function efficiency")
    void testZeroWithOddLenOrOneWithEvenLenRegEx(String string, boolean result) {
        assert (Task8.zeroWithOddLenOrOneWithEvenLenRegEx(string) == result);
    }

    static class TestArgumentsProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("100010", true),
                Arguments.of("010101", false),
                Arguments.of("1", false),
                Arguments.of("java", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider3.class)
    @DisplayName("Checking numberOf0IsDivisibleBy3RegEx function efficiency")
    void testNumberOf0IsDivisibleBy3RegEx(String string, boolean result) {
        assert (Task8.numberOf0IsDivisibleBy3RegEx(string) == result);
    }

    static class TestArgumentsProvider3 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("100101", true),
                Arguments.of("000010", false),
                Arguments.of("1001001010", true),
                Arguments.of("111", true),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider4.class)
    @DisplayName("Checking anyStringOtherThan11Or111RegEx function efficiency")
    void testAnyStringOtherThan11Or111RegEx(String string, boolean result) {
        assert (Task8.anyStringOtherThan11Or111RegEx(string) == result);
    }

    static class TestArgumentsProvider4 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("1111", true),
                Arguments.of("1", true),
                Arguments.of("11", false),
                Arguments.of("111", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider5.class)
    @DisplayName("Checking eachOddCharacterIsEqualTo1RegEx function efficiency")
    void testEachOddCharacterIsEqualTo1RegEx(String string, boolean result) {
        assert (Task8.eachOddCharacterIsEqualTo1RegEx(string) == result);
    }

    static class TestArgumentsProvider5 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("10101", true),
                Arguments.of("1", true),
                Arguments.of("10000001", false),
                Arguments.of("0", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider6.class)
    @DisplayName("Checking containsAtLeastTwo0AndAtMostOne1RegEx function efficiency")
    void testContainsAtLeastTwo0AndAtMostOne1RegEx(String string, boolean result) {
        assert (Task8.containsAtLeastTwo0AndAtMostOne1RegEx(string) == result);
    }

    static class TestArgumentsProvider6 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("00", true),
                Arguments.of("0000010", true),
                Arguments.of("11110", false),
                Arguments.of("0", false),
                Arguments.of(null, false)
            );
        }
    }

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task8Test.TestArgumentsProvider7.class)
    @DisplayName("Checking noConsecutive1RegEx function efficiency")
    void testNoConsecutive1RegEx(String string, boolean result) {
        assert (Task8.noConsecutive1RegEx(string) == result);
    }

    static class TestArgumentsProvider7 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("10101", true),
                Arguments.of("010001", true),
                Arguments.of("11110", false),
                Arguments.of("0101101", false),
                Arguments.of(null, false)
            );
        }
    }
}
