package edu.hw8;

import edu.hw8.Task3.PasswordHack;
import edu.hw8.Task3.PasswordHackMultiThread;
import edu.hw8.Task3.PasswordHackSingleThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Password hacks check")
    void testPasswordHack() {
        Map<String, String> hashedPasswords1 = new HashMap<>(Map.ofEntries(
            Map.entry("81dc9bdb52d04dc20036dbd8313ed055", "a.v.petrov"),//1234
            Map.entry("5531a5834816222280f20d1ef9e95f69", "a.s.ivanov"),//2023
            Map.entry("5a3b732e0600663606054f6d8dfd465e", "k.p.maslov")//bacd
        ));
        var hashedPasswords2 = new HashMap<>(hashedPasswords1);
        PasswordHack singleThreadPasswordHack = new PasswordHackSingleThread(hashedPasswords1);
        PasswordHack multiThreadPasswordHack = new PasswordHackMultiThread(hashedPasswords2);
        long t1Start = System.currentTimeMillis();
        Map<String, String> resultLinear = singleThreadPasswordHack.nextPassword(4);
        long t1 = System.currentTimeMillis() - t1Start;
        long t2Start = System.currentTimeMillis();
        Map<String, String> resultMultiThread = multiThreadPasswordHack.nextPassword(4);
        long t2 = System.currentTimeMillis() - t2Start;
        LOGGER.info("Разница: " + (t1 - t2));
        assertThat(resultLinear).isEqualTo(resultMultiThread);
        assertThat(resultLinear.size()).isEqualTo(3);
    }
}
