package connect4.utils;

public class Interval {

    private int min;
    private int max;

    public Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isBetweenExclusive(int value) {
        return value > min && value < max;
    }
}
