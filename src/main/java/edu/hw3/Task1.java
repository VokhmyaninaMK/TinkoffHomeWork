package edu.hw3;

public class Task1 {
    private Task1() {

    }

    static String atbash(String originalString) {
        char[] encryption = originalString.toCharArray();
        for (int i = 0; i < encryption.length; i++) {
            if (encryption[i] >= 'a' && encryption[i] <= 'z') {
                encryption[i] = (char) ('a' + 'z' - encryption[i]);
            } else if (encryption[i] >= 'A' && encryption[i] <= 'Z') {
                encryption[i] = (char) ('A' + 'Z' - encryption[i]);
            }
        }
        return new String(encryption);
    }
}
