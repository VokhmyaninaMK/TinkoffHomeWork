package edu.hw1;

public class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTE = 60;

    public static long minutesToSeconds(String durationOfVideo) {
        for (int i = 0; i < durationOfVideo.length(); i++) {
            if ((durationOfVideo.charAt(i) < '0' || durationOfVideo.charAt(i) > '9')
                && durationOfVideo.charAt(i) != ':') {
                return -1;
            }
        }
        String[] tokenArray = durationOfVideo.split(":");
        if (Long.parseLong(tokenArray[1]) >= SECONDS_IN_MINUTE || tokenArray.length != 2
            || Long.parseLong(tokenArray[0]) < 0
            || Long.parseLong(tokenArray[1]) < 0) {
            return -1;
        }
        return Long.parseLong(tokenArray[1]) + Long.parseLong(tokenArray[0]) * SECONDS_IN_MINUTE;
    }
}

