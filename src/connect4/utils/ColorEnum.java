package connect4.utils;

import java.util.List;

import static java.util.List.of;

public enum ColorEnum {
    RED, BLUE, NULL_COLOR;
    public static final List<ColorEnum> ALL_BUT_NULL_COLOR = of(RED, BLUE);

    @Override
    public String toString() {
        return switch (this) {
            case RED -> "X";
            case BLUE -> "O";
            case NULL_COLOR -> "-";
        };
    }
}
