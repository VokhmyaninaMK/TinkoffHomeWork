package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean substringSearch(String string, String substring) {
        if (string == null || substring == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(".*" + substring + ".*");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
