package edu.hw8.Task3;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class PasswordHackSingleThread implements PasswordHack {

    private final MessageDigest md5;
    private final Map<String, String> hashedPasswords;
    private final Map<String, String> resultPasswords;
    private final Queue<String> passwords;
    private static final int MD5_ENCODE = 16;

    public PasswordHackSingleThread(Map<String, String> hashedPasswords) {
        this.hashedPasswords = hashedPasswords;
        this.resultPasswords = new HashMap<>();
        this.passwords = new ArrayDeque<>();
        try {
            this.md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> nextPassword(int maxLength) {
        passwords.add("");
        while (!hashedPasswords.isEmpty() && !passwords.isEmpty()) {
            String password = passwords.poll();
            try {
                String currentHash = (new BigInteger(1,
                    md5.digest(password.getBytes(StandardCharsets.UTF_8)))).toString(MD5_ENCODE);

                if (hashedPasswords.containsKey(currentHash)) {
                    resultPasswords.put(password, hashedPasswords.get(currentHash));
                    hashedPasswords.remove(currentHash);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            passwordGenerator(password, maxLength);
        }
        passwords.clear();
        return resultPasswords;
    }

    @Override
    public void passwordGenerator(String basicPassword, int maxLength) {
        if (basicPassword.length() < maxLength) {
            for (int i = 'A'; i <= (int) 'Z'; i++) {
                passwords.add(basicPassword + (char) i);
            }
            for (int i = 'a'; i <= (int) 'z'; i++) {
                passwords.add(basicPassword + (char) i);
            }
            for (int i = '0'; i <= (int) '9'; i++) {
                passwords.add(basicPassword + (char) i);
            }
        }
    }

}
