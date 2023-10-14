package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int originalNumber, int numberOfDigits) {
        int initialNumberOfDigits = numberOfDigits;
        if (originalNumber > 0 || initialNumberOfDigits < 0) {
            char[] binNumberArray = Integer.toBinaryString(originalNumber).toCharArray();
            char[] newBinNumberArray = new char[binNumberArray.length];
            initialNumberOfDigits %= binNumberArray.length;
            for (int index = initialNumberOfDigits; index < binNumberArray.length; index++) {
                newBinNumberArray[index - initialNumberOfDigits] = binNumberArray[index];
            }
            for (int index = 0; index < initialNumberOfDigits; index++) {
                newBinNumberArray[binNumberArray.length + index - initialNumberOfDigits] = binNumberArray[index];
            }
            String s = new String(newBinNumberArray);
            return Integer.valueOf(s, 2);
        }
        return -1;
    }

    public static int rotateRight(int originalNumber, int numberOfDigits) {
        int initialNumberOfDigits = numberOfDigits;
        if (originalNumber > 0 || initialNumberOfDigits < 0) {
            char[] binNumberArray = Integer.toBinaryString(originalNumber).toCharArray();
            char[] newBinNumberArray = new char[binNumberArray.length];
            initialNumberOfDigits %= binNumberArray.length;
            for (int index = initialNumberOfDigits; index < binNumberArray.length; index++) {
                newBinNumberArray[index] = binNumberArray[index - initialNumberOfDigits];
            }
            for (int index = binNumberArray.length - initialNumberOfDigits; index < binNumberArray.length; index++) {
                newBinNumberArray[index - binNumberArray.length + initialNumberOfDigits] = binNumberArray[index];
            }
            String s = new String(newBinNumberArray);
            return Integer.valueOf(s, 2);
        }
        return -1;
    }
}
