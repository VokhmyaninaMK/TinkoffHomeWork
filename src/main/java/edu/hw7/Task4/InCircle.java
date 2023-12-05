package edu.hw7.Task4;

public class InCircle {
    private InCircle() {

    }

    private static final int POW = 2;
    private static final double CENTER_CORDS = 0.5;
    private static final double RADIUS = 0.5;

    public static boolean locateInCircle(double x, double y) {
        return distanceBetweenDots(x, y) <= RADIUS;
    }

    private static double distanceBetweenDots(double x, double y) {
        return Math.sqrt(Math.pow(CENTER_CORDS - x, POW) + Math.pow(CENTER_CORDS - y, POW));
    }
}
