package edu.hw2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    TestLogger logger = TestLoggerFactory.getTestLogger(Task3.class);


    @Test
    @DisplayName("Checking TryExecute function efficiency")
    void testTryConnection() {
        for (int attempt = 0; attempt < 200; attempt++) {
            connectionTryTest();
        }
    }

    void connectionTryTest() {
        Task3.PopularCommandExecutor popularCommandExecutor = new Task3.PopularCommandExecutor();
        popularCommandExecutor.updatePackages();

        if (logger.getLoggingEvents().asList().get(0).getMessage().equals("Connection is successful")
            || logger.getLoggingEvents().asList().get(0).getMessage().equals("Connection closing error")) {
            assertThat(1).isEqualTo(1);
        } else if (logger.getLoggingEvents().asList().get(0).getMessage()
            .equals("Limit of attempts was exceeded")) {

            for (int attempt = 1; attempt <= 9; attempt += 2) {
                assertThat(logger.getLoggingEvents().asList().get(attempt).getMessage())
                    .isEqualTo("Connection was closed");

                assertThat(logger.getLoggingEvents().asList().get(attempt + 1).getMessage())
                    .isEqualTo("Connection error");
            }
        }
    }

    @AfterAll
    public static void clearLoggers() {
        TestLoggerFactory.clear();
    }
}
