package edu.hw8.Task3;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PasswordHackMultiThread implements PasswordHack {

    private final MessageDigest md5;
    private final ReadWriteLock lock;
    private final Map<String, String> hashedPasswords;
    private final Map<String, String> resultPasswords;
    private final Queue<String> passwords;

    private static final int THREADS_COUNT = 6;
    private static final int MD5_ENCODE = 16;

    public PasswordHackMultiThread(Map<String, String> hashedPasswords) {
        this.hashedPasswords = hashedPasswords;
        this.passwords = new ArrayDeque<>();
        this.resultPasswords = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> nextPassword(int maxLength) {
        passwords.add("");
        for (int threadCount = 0; threadCount < THREADS_COUNT; threadCount++) {
            Thread thread = new Thread(() -> {
                while (!hashedPasswords.isEmpty() && !passwords.isEmpty()) {
                    String password = null;
                    lock.readLock().lock();
                    try {
                        password = passwords.poll();
                    } finally {
                        lock.readLock().unlock();
                    }
                    if (password == null) {
                        continue;
                    }
                    try {
                        String currentHash = (new BigInteger(
                            1,
                            md5.digest(password.getBytes(StandardCharsets.UTF_8))
                        )).toString(MD5_ENCODE);

                        lock.writeLock().lock();
                        try {

                            if (hashedPasswords.containsKey(currentHash)) {
                                resultPasswords.put(password, hashedPasswords.get(currentHash));
                                hashedPasswords.remove(currentHash);
                            }
                        } finally {
                            lock.writeLock().unlock();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    passwordGenerator(password, maxLength);
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        passwords.clear();
        return resultPasswords;
    }

    @Override
    public synchronized void passwordGenerator(String basicPassword, int maxLength) {
        if (basicPassword.length() < maxLength) {
            lock.writeLock().lock();
            try {
                for (int i = 'A'; i <= (int) 'Z'; i++) {
                    passwords.add(basicPassword + (char) i);
                }
                for (int i = 'a'; i <= (int) 'z'; i++) {
                    passwords.add(basicPassword + (char) i);
                }
                for (int i = '0'; i <= (int) '9'; i++) {
                    passwords.add(basicPassword + (char) i);
                }
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
