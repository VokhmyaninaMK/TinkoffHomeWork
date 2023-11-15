package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {

    private Task8() {
    }

    public static boolean oddLengthRegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^([0-1]{2})*[0-1]$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean zeroWithOddLenOrOneWithEvenLenRegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(0([0-1]{2})*)$|^(1([0-1]{2})*[0-1])$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean numberOf0IsDivisibleBy3RegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^((1*(0)){3}1*)*$|^([^0]*)$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean anyStringOtherThan11Or111RegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^11$|^111$");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
            return false;
        pattern = Pattern.compile("^[01]+$");
        matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean eachOddCharacterIsEqualTo1RegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^1([0-1]1)*[0-1]?$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean containsAtLeastTwo0AndAtMostOne1RegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(0+1?0+)$|^(1?(0+){2})$|^((0+){2}1?)$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean noConsecutive1RegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(1?(0+1?)*)$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
