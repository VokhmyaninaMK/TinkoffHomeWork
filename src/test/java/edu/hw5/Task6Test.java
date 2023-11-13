package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Task6Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task6Test.TestArgumentsProvider.class)
    @DisplayName("Checking substringSearch function efficiency")
    void testSubstringSearch(String string, String substring, boolean result) {
        assert(Task6.substringSearch(string, substring)==result);
    }

    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("abcdljfwlwk;", "cdl", true),
                Arguments.of("pizza_and_juice", "apple", false),
                Arguments.of("cows_ans_dogs", "_", true),
                Arguments.of("i_love_c++", "java", false),
                Arguments.of(null, null, false)
            );
        }
    }
}
