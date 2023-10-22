package edu.hw2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task3 {
    private final static String STABLE_CONNECTION = "Connection is successful";
    private final static String ERROR_OF_CONNECTION = "Connection error";
    private final static String ERROR_OF_CLOSING_CONNECTION = "Connection closing error";
    private final static String CLOSE_CONNECTION = "Connection was closed";
    private final static String LIMIT_EXCEEDED = "Limit of attempts was exceeded";

    private final static int PERCENTS = 100;
    private final static int PROBABILITY_PERCENTS = 90;
    private final static Logger LOGGER = LoggerFactory.getLogger(Task3.class);

     public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            double abilityOfConnection = Math.random() * PERCENTS;
            if (abilityOfConnection >= PERCENTS - PROBABILITY_PERCENTS) {
                return new StableConnection();
            } else {
                return new FaultyConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            LOGGER.info(STABLE_CONNECTION);
        }

        @Override
        public void close() throws Exception {
            LOGGER.info(CLOSE_CONNECTION);
        }
    }

    public static class FaultyConnection implements Connection {
        @Override
        public void execute(String command) {
            double abilityOfConnection = Math.random() * PERCENTS;
            if (abilityOfConnection <= PROBABILITY_PERCENTS) {
                throw new ConnectionException();
            } else {

                LOGGER.info(STABLE_CONNECTION);
            }
        }

        @Override
        public void close() throws Exception {
            LOGGER.info(CLOSE_CONNECTION);
        }
    }

    public static class ConnectionException extends RuntimeException {
    }

    public static final class PopularCommandExecutor {

        private final ConnectionManager manager = new DefaultConnectionManager();
        private final int maxAttempts = 10;

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {

            int counterOfAttempts = 0;
            Connection connection = manager.getConnection();
            boolean limitExceed = false;

            while (counterOfAttempts < maxAttempts) {
                try {
                    connection = manager.getConnection();
                    connection.execute(command);

                    limitExceed = true;
                    break;
                } catch (ConnectionException connectionException) {
                    LOGGER.info(ERROR_OF_CONNECTION);
                }

                counterOfAttempts++;

                try {
                    connection.close();
                } catch (Exception exception) {
                    LOGGER.info(ERROR_OF_CLOSING_CONNECTION);
                    limitExceed = true;
                    break;
                }
            }

            if (!limitExceed) {
                LOGGER.info(LIMIT_EXCEEDED);
            }
        }
    }
}
