package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    private Task5() {
    }

    public static boolean correctCarNumber(String carNumber) {
        if (carNumber == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^([А-Я])([0-9]{3})([А-Я]{2})([0-9]{3})$");
        Matcher matcher = pattern.matcher(carNumber);
        return matcher.find();
    }
}
