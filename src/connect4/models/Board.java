package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.Interval;

import java.util.Arrays;

public class Board {

    private final int maxRows = 6;
    private final int maxColumns = 7;
    private final ColorEnum[][] colors;

    public Board() {
        this.colors = new ColorEnum[this.maxRows][this.maxColumns];
        for (int i = 0; i < this.maxRows; i++) {
            for (int j = 0; j < this.maxColumns; j++) {
                this.colors[i][j] = ColorEnum.NULLCOLOR;
            }
        }
    }

    public boolean hasWinner(ColorEnum color) {
        //TODO
        return false;
    }

    public void putColumn(Coordinate coordinate, ColorEnum color) {
        this.colors[coordinate.getX()][coordinate.getY()] = color;
    }

    public boolean isFull() {
        return !Arrays.asList(this.colors[0]).contains(ColorEnum.NULLCOLOR);
    }

    public int getMaxRows() {
        return maxRows;
    }

    public int getMaxColumns() {
        return maxColumns;
    }

    public ColorEnum[][] getColors() {
        return colors;
    }

    public boolean isOnBoard(int column) {
        return new Interval(-1, this.maxColumns).isBetweenExclusive(column);
    }

    public boolean isAvailableCoordinate(Coordinate coordinate) {
        return coordinate.isAvailable(this);
    }

    public boolean isAvailableColumn(int column) {
        return this.colors[0][column] == ColorEnum.NULLCOLOR;
    }

}
