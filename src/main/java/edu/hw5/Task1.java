package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private Task1() {
    }

    private static final String TIME_PATTERN = "yyyy-MM-dd, HH:mm";

    public static Duration averagePlayingTime(ArrayList<String> originalArray) {
        Pattern timePattern = Pattern.compile("^(.*) - (.*)$");

        int countOfSessions = 0;
        long countOfSeconds = 0;

        for (String session : originalArray) {
            Matcher playingTimeMatcher = timePattern.matcher(session);

            if (playingTimeMatcher.find() && playingTimeMatcher.groupCount() == 2) {
                LocalDateTime firstDate = DateTimeFormatter.ofPattern(TIME_PATTERN)
                    .parse(playingTimeMatcher.group(1), LocalDateTime::from);

                LocalDateTime secondDate = DateTimeFormatter.ofPattern(TIME_PATTERN)
                    .parse(playingTimeMatcher.group(2), LocalDateTime::from);

                if (secondDate.isAfter(firstDate)) {
                    countOfSessions++;
                    countOfSeconds += firstDate.until(secondDate, ChronoUnit.SECONDS);
                }
            }
        }

        if (countOfSessions == 0) {
            return null;
        } else {
            return Duration.ofSeconds(countOfSeconds / countOfSessions);
        }
    }
}
