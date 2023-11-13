package edu.hw5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Task2 {

    private Task2() {
    }

    private static final int FRIDAY_13TH = 13;
    private static final int FIRST_CALENDAR_YEAR = 1900;
    private static final SimpleDateFormat FORMAT_OF_DATE = new SimpleDateFormat("yyyy-MM-dd");

    public static ArrayList<String> searchFriday13Th(int year) {
        int month = 0;
        ArrayList<String> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        while (month < FRIDAY_13TH) {
            calendar.set(year, month, FRIDAY_13TH);

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                result.add(FORMAT_OF_DATE.format(new Date(year - FIRST_CALENDAR_YEAR, month,
                    FRIDAY_13TH
                )));
            }
            month++;
        }

        return result;
    }

    public static LocalDate nextFriday13Th(LocalDate currentDay) {
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.ofDateAdjuster(localDate -> {
            ArrayList<String> fridays13ThInThisYear = searchFriday13Th(localDate.getYear());
            for (int index = 0; index < fridays13ThInThisYear.size(); index++) {

                if (LocalDate.parse(fridays13ThInThisYear.get(index)).equals(localDate)
                    && index != fridays13ThInThisYear.size() - 1) {

                    return LocalDate.parse(fridays13ThInThisYear.get(index + 1));
                }
            }
            for (int index = 1; ; index++) {
                fridays13ThInThisYear = searchFriday13Th(localDate.getYear() + index);

                if (!fridays13ThInThisYear.isEmpty()) {
                    return LocalDate.parse(fridays13ThInThisYear.getFirst());
                }
            }
        });

        return currentDay.with(temporalAdjuster);
    }
}
