package edu.hw1;

public class Task3 {
    private Task3() {
    }

    private static long minArrayValue(long[] currentArray) {
        long minValue = currentArray[0];
        for (long l : currentArray) {
            minValue = Math.min(minValue, l);
        }
        return minValue;
    }

    private static long maxArrayValue(long[] currentArray) {
        long maxValue = currentArray[0];
        for (long l : currentArray) {
            maxValue = Math.max(maxValue, l);
        }
        return maxValue;
    }

    public static boolean isNestable(long[] nestableArray, long[] expandableArray) {
        return nestableArray.length != 0 && expandableArray.length != 0
            && minArrayValue(nestableArray) > minArrayValue(expandableArray)
            && maxArrayValue(nestableArray) < maxArrayValue(expandableArray);
    }
}

