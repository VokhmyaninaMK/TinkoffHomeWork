package edu.hw7.Task4Test;

import edu.hw7.Task4.LinearAlgorithm;
import edu.hw7.Task4.MultiThreadingAlgorithm;
import org.junit.jupiter.api.DisplayName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlgorithmsTimeTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(AlgorithmsTimeTest.TimeTestArgumentsProvider.class)
    @DisplayName("Comparative time test of algorithms")
    void comparativeTimeTestMonteCarloAlgorithm(int attempts, int threads) {

        LinearAlgorithm.linearSolvingPi(attempts);
        long t1 = LinearAlgorithm.getTime();

        MultiThreadingAlgorithm.multiThreadingSolvingPi(attempts, threads);
        long t2 = MultiThreadingAlgorithm.getTime();

        LOGGER.info(t1);
        LOGGER.info(t2);
        LOGGER.info("Разница: " + (t1 - t2));

        assertThat(t1).isGreaterThan(t2);
    }

    static class TimeTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(1000, 6),
                Arguments.of(100_000, 6),
                Arguments.of(1_000_000, 6)
            );
        }
    }
}
