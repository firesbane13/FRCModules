package frc.lib.helper;

public class Conversions {

    private Conversions() {
        // Empty constructor
    }

    public static double millisecondsToHz(double milliseconds) {
        double seconds = milliseconds / 1000;

        return 1 / seconds;
    }

    public static double hzToMilliseconds(double hz) {
        double seconds = 1 / hz;

        return seconds * 1000;
    }
}