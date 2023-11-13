package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Task5Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task5Test.TestArgumentsProvider.class)
    @DisplayName("Checking correctCarNumber function efficiency")
    void testCorrectCarNumber(String carNumber, boolean result) {
        assert(Task5.correctCarNumber(carNumber)==result);
    }

    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("А394ОР122", true),
                Arguments.of("АР94ОР122", false),
                Arguments.of("А094ОР1В2", false),
                Arguments.of("394ОР122", false),
                Arguments.of(null, false)
            );
        }
    }
}
