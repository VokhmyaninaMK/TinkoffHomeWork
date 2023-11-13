package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static edu.hw5.Task4.correctPassword;

public class Task4Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task4Test.TestArgumentsProvider.class)
    @DisplayName("Checking correctPassword function efficiency")
    void testCorrectPassword(String password, boolean result) {
        assert(correctPassword(password)==result);
    }

    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of("Hello_World", false),
                Arguments.of("OK!password_#|", true),
                Arguments.of("@~@", true),
                Arguments.of(null, false)
            );
        }
    }
}
