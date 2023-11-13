package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String givenDate) {
        DateParser dateParser = getParsersChain();
        LocalDate resultDate = dateParser.stringTransform(givenDate);

        if (resultDate == null) {
            return Optional.empty();
        } else {
            return Optional.of(resultDate);
        }
    }

    private static DateParser getParsersChain() {
        FourthDateParser fourthDateParser = new FourthDateParser(null);
        ThirdDateParser thirdDateParser = new ThirdDateParser(fourthDateParser);
        SecondDateParser secondDateParser = new SecondDateParser(thirdDateParser);
        return new FirstDateParser(secondDateParser);
    }

    private abstract static class DateParser {
        protected DateParser nextParser;

        private DateParser(DateParser nextParser) {
            this.nextParser = nextParser;
        }

        public abstract LocalDate stringTransform(String givenDate);
    }

    //yyyy-mm-dd
    private static class FirstDateParser extends DateParser {

        private static final DateTimeFormatter DATE_FORMAT_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        private static final DateTimeFormatter DATE_FORMAT_2 = DateTimeFormatter.ofPattern("yyyy-MM-d");

        private FirstDateParser(DateParser nextParser) {
            super(nextParser);
        }

        @Override
        public LocalDate stringTransform(String originalDate) {
            if (originalDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return LocalDate.parse(originalDate, DATE_FORMAT_1);
            } else if (originalDate.matches("\\d{4}-\\d{2}-\\d")) {
                return LocalDate.parse(originalDate, DATE_FORMAT_2);
            } else if (nextParser != null) {
                return nextParser.stringTransform(originalDate);
            } else {
                return null;
            }
        }
    }

    //dd/mm/yy(yy)
    private static class SecondDateParser extends DateParser {

        private static final DateTimeFormatter DATE_TIME_FORMATTER_1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        private static final DateTimeFormatter DATE_TIME_FORMATTER_2 = DateTimeFormatter.ofPattern("d/M/yy");

        private SecondDateParser(DateParser nextParser) {
            super(nextParser);
        }

        @Override
        public LocalDate stringTransform(String originalDate) {
            if (originalDate.matches("\\d/\\d/\\d{4}")) {
                return LocalDate.parse(originalDate, DATE_TIME_FORMATTER_1);
            } else if (originalDate.matches("\\d/\\d/\\d{2}")) {
                return LocalDate.parse(originalDate, DATE_TIME_FORMATTER_2);
            } else if (nextParser != null) {
                return nextParser.stringTransform(originalDate);
            } else {
                return null;
            }
        }
    }

    //today/tomorrow/yesterday
    private static class ThirdDateParser extends DateParser {

        private ThirdDateParser(DateParser nextParser) {
            super(nextParser);
        }

        @Override
        public LocalDate stringTransform(String originalDate) {
            LocalDate result;
            if (originalDate.equals("today")) {
                result = LocalDate.now();
            } else if (originalDate.equals("yesterday")) {
                result = LocalDate.now().minusDays(1);
            } else if (originalDate.equals("tomorrow")) {
                result = LocalDate.now().plusDays(1);
            } else if (nextParser != null) {
                result = nextParser.stringTransform(originalDate);
            } else {
                result = null;
            }
            return result;
        }
    }

    //n days ago
    private static class FourthDateParser extends DateParser {

        private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d+) .* ago$");

        private FourthDateParser(DateParser nextParser) {
            super(nextParser);
        }

        @Override
        public LocalDate stringTransform(String originalDate) {
            Matcher timeMatcher = DATE_PATTERN.matcher(originalDate);

            if (timeMatcher.find()) {
                return LocalDate.now().minusDays(Long.parseLong(timeMatcher.group(1)));
            } else if (nextParser != null) {
                return nextParser.stringTransform(originalDate);
            } else {
                return null;
            }
        }
    }
}
