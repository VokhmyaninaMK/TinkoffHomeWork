package edu.hw1;

public class Task5 {
    private Task5() {
    }

    private static boolean checkingForPalindrome(String potentialPalindrome) {
        for (int index = 0; index < potentialPalindrome.length() / 2; index++) {
            if (potentialPalindrome.charAt(index)
                != potentialPalindrome.charAt(potentialPalindrome.length() - index - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromeDescendant(String potentialPalindrome) {
        String currentPotentialPalindrome = potentialPalindrome;

        if (currentPotentialPalindrome.length() > 1 && checkingForPalindrome(currentPotentialPalindrome)) {
            return true;
        }
        while (currentPotentialPalindrome.length() > 1 && currentPotentialPalindrome.length() % 2 == 0) {
            StringBuilder newPotentialPalindrome = new StringBuilder();
            for (int index = 0; index < currentPotentialPalindrome.length(); index += 2) {
                String sumOfTwoElements =
                    Integer.toString(Character.getNumericValue(currentPotentialPalindrome.charAt(index))
                        + Character.getNumericValue(currentPotentialPalindrome.charAt(index + 1)));
                newPotentialPalindrome.append(sumOfTwoElements);
            }
            if (checkingForPalindrome(newPotentialPalindrome.toString()) && newPotentialPalindrome.length() > 1) {
                return true;
            }
            currentPotentialPalindrome = new String(newPotentialPalindrome);
        }
        return false;
    }
}
