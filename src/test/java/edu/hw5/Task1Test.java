package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class Task1Test {
    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task1Test.TestArgumentsProvider1.class)
    @DisplayName("Checking averagePlayingTime function efficiency")
    void testAveragePlayingTime(ArrayList<String> times, Duration result) {
        assert (Objects.equals(Task1.averagePlayingTime(times), result));
    }

    static class TestArgumentsProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(
                    "2022-04-12, 14:44 - 2022-04-12, 02:12",
                    "2022-10-01, 21:23 - 2022-10-01, 19:56"
                )), null),
                Arguments.of(new ArrayList<>(Arrays.asList(
                    "2022-04-12, 14:44 - 2022-04-12, 16:55",
                    "2022-10-01, 21:23 - 2022-10-01, 22:56"
                )), Duration.ofMinutes(60 + 52)),
                Arguments.of(new ArrayList<>(Arrays.asList(
                    "2022-04-12, 14:44 - 2022-04-12, 15:12",
                    "2022-10-01, 17:00 - 2022-10-01, 19:18"
                )), Duration.ofMinutes(60 + 23)),
                Arguments.of(new ArrayList<>(Arrays.asList(
                    "2022-04-12, 14:44 - 2022-04-12, 22:18",
                    "2022-10-01, 21:23 - 2022-10-01, 23:59"
                )), Duration.ofMinutes(5 * 60 + 5))
            );
        }
    }
}
