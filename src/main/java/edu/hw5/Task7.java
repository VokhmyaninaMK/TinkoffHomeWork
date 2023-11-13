package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {

    private Task7() {
    }

    public static boolean firstRegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-1]{2}0[0-1]*$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean secondRegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^0$|^1$|^(0[0-1]*0)$|^(1[0-1]*1)$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean thirdRegEx(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-1]{1,3}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
