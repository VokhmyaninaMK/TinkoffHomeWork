package edu.hw6.Task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortScanner {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PARSE_PORTS_PATTERN = Pattern.compile("([0-9]{1,5}) ([A-z0-9_\\-/]+) ([A-z|/]+)");
    private static final int NUMBER_OF_PORTS = 49151;

    private static final String ERROR_DURING_OPENING_FILE = "Error during opening file";
    private static final String PARAMS_SEPARATOR = "     ";
    private static final String TABLE_DESCRIPTION = "PROTOCOL     PORT     SERVICE";
    private static final String FILEPATH = "src/main/java/edu/hw6/Task6/Ports.txt";

    private PortScanner() {
    }

    public static ArrayList<String> portScanner() {
        LOGGER.info(TABLE_DESCRIPTION);

        ArrayList<String> occupiedPorts = new ArrayList<>();

        for (int portNumber = 0; portNumber <= NUMBER_OF_PORTS; portNumber++) {
            StringBuilder resultPortString = new StringBuilder();

            boolean currentPortISFree = true;

            try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                serverSocket.setReuseAddress(true);
            } catch (IOException e) {
                resultPortString.append("TCP" + PARAMS_SEPARATOR).append(portNumber);
                currentPortISFree = false;
            }

            if (currentPortISFree) {
                try (DatagramSocket datagramSocket = new DatagramSocket(portNumber)) {
                    datagramSocket.setReuseAddress(true);
                    continue;
                } catch (IOException e) {
                    resultPortString.append("UDP" + PARAMS_SEPARATOR).append(portNumber);
                }
            }

            boolean serviceFound = false;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILEPATH))) {
                String currentPort;
                while ((currentPort = bufferedReader.readLine()) != null) {
                    Matcher matcher = PARSE_PORTS_PATTERN.matcher(currentPort);
                    if (matcher.find() && (Integer.parseInt(matcher.group(1))) == portNumber) {
                        serviceFound = true;
                        String currentPortService = matcher.group(2);
                        resultPortString.append(PARAMS_SEPARATOR).append(currentPortService);
                    }
                }
            } catch (IOException e) {
                LOGGER.error(ERROR_DURING_OPENING_FILE);
                throw new RuntimeException(e);
            }

            if (!serviceFound) {
                resultPortString.append(PARAMS_SEPARATOR).append("N/A");
            }

            occupiedPorts.add(resultPortString.toString());
            LOGGER.info(resultPortString.toString());
        }

        return occupiedPorts;
    }
}
