package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;

public abstract class Player {

    private final ColorEnum color;

    public Player(ColorEnum color) {
        this.color = color;
    }

    public abstract Coordinate selectCoordinatePoint(Game game);

    public ColorEnum getColor() {
        return color;
    }
}
