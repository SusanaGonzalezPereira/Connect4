package connect4.utils;

import connect4.models.Board;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int column, Board board) {
        this.x = getAvailableCoordinateX(column, board);
        this.y = column;
    }

    private int getAvailableCoordinateX(int column, Board board) {
        assert board.getColors()[board.getMaxRows()][column] == ColorEnum.NULLCOLOR;
        int i = board.getMaxRows() - 1;
        while (board.getColors()[i][column] != ColorEnum.NULLCOLOR) {
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
        if (board.getColors()[this.x][this.y] == ColorEnum.NULLCOLOR) {
            return true;
        }
        return false;
    }
}
