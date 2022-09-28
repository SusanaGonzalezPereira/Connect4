package connect4.utils;

import connect4.models.Board;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int column, Board board) {
        this.x = this.getAvailableCoordinateX(column, board);
        this.y = column;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int getAvailableCoordinateX(int column, Board board) {
        assert board.getColors()[board.getMaxRows()][column] == ColorEnum.NULL_COLOR;
        int i = board.getMaxRows() - 1;
        while (board.getColors()[i][column] != ColorEnum.NULL_COLOR) {
            i--;
        }
        return i;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAvailable(Board board) {
        return board.getColors()[this.x][this.y] == ColorEnum.NULL_COLOR;
    }

    public Coordinate nextOppositeDirection(DirectionEnum direction) {
        return new Coordinate(this.x + direction.opposite()[1], this.y + direction.opposite()[0]);
    }

    public Coordinate nextDirection(DirectionEnum direction) {
        return new Coordinate(this.x + direction.values[1], this.y + direction.values[0]);
    }


}
