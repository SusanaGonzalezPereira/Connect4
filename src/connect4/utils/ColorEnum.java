package connect4.utils;

import java.util.List;

import static java.util.List.*;

public enum ColorEnum {
    RED, BLUE, NULLCOLOR;
    public static final List<ColorEnum> ALL_BUT_NULL_COLOR = of(RED, BLUE);

    @Override
    public String toString() {
        return switch (this) {
            case RED -> "R";
            case BLUE -> "B";
            case NULLCOLOR -> "-";
        };
    }
}
