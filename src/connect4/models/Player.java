package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;

public class Player {

    private final Board board;
    private final ColorEnum color;

    public Player(ColorEnum color, Board board) {
        this.board = board;
        this.color = color;
    }

    public void putColor(Coordinate coordinate) {
        this.board.putColumn(coordinate, color);
    }

    public ColorEnum getColor() {
        return color;
    }
}
