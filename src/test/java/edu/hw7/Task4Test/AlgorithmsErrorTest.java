package edu.hw7.Task4Test;

import edu.hw7.Task4.MultiThreadingAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlgorithmsErrorTest {
    private static final double ERROR_RATE = 0.01;

    private static final Logger LOGGER = LogManager.getLogger();

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(AlgorithmsErrorTest.MathErrorRateTestArgumentsProvider.class)
    @DisplayName("Math error rate test of algorithms")
    void testAlgorithmError(int attempts, int threads) {

        MultiThreadingAlgorithm.multiThreadingSolvingPi(attempts, threads);
        double result = MultiThreadingAlgorithm.getPiResult();
        double errorRate = MultiThreadingAlgorithm.getMathErrorRate();

        LOGGER.info(result);
        LOGGER.info(errorRate);
        assertThat(errorRate).isLessThan(ERROR_RATE);
    }

    static class MathErrorRateTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(10000000, 6),
                Arguments.of(100000000, 6),
                Arguments.of(1000000000, 6)
            );
        }
    }
}
