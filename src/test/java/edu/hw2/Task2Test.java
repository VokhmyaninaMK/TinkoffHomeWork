package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @ParameterizedTest(name = "#{index} - Run with args = {0}")
    @ArgumentsSource(Task2Test.TestArgumentsProvider.class)
    @DisplayName("Checking LSP problem solution")
    void testLSPSolution(Task2.Rectangle rectangle, int width, int height, int writeArea) {
        Task2.Rectangle resultRectangle = rectangle.setWidth(width);
        resultRectangle.setHeight(height);

        assertThat(resultRectangle.area()).isEqualTo(writeArea);
    }

    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                //Object, width, height, area
                Arguments.of(new Task2.Rectangle(), 12, 25, 300),
                Arguments.of(new Task2.Square(), 5, 10, 50),
                Arguments.of(new Task2.Rectangle(), 6, 6, 36),
                Arguments.of(new Task2.Square(), 9, 9, 81)
            );
        }
    }
}
