package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.DirectionEnum;
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
                this.colors[i][j] = ColorEnum.NULL_COLOR;
            }
        }
    }

    public boolean hasWinner(ColorEnum color, Coordinate coordinate, DirectionEnum direction) {
        Coordinate currentCoordinate = this.moveOpposite(color, coordinate, direction);
        return isWinnerDirection(color, currentCoordinate, direction);
    }

    public void putColumn(Coordinate coordinate, ColorEnum color) {
        this.colors[coordinate.getX()][coordinate.getY()] = color;
    }

    public boolean isFull() {
        return !Arrays.asList(this.colors[0]).contains(ColorEnum.NULL_COLOR);
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

    public boolean isInsideBoard(Coordinate coordinate){
        return new Interval(-1,this.maxColumns).isBetweenExclusive(coordinate.getY())
                && new Interval(-1, this.maxRows).isBetweenExclusive(coordinate.getX());
    }

    public boolean isAvailableCoordinate(Coordinate coordinate) {
        return coordinate.isAvailable(this);
    }

    public boolean isAvailableColumn(int column) {
        return this.colors[0][column] == ColorEnum.NULL_COLOR;
    }

    private Coordinate moveOpposite(ColorEnum color, Coordinate coordinate, DirectionEnum direction){
        Coordinate oppositeCoordinate = new Coordinate(coordinate.getX() + direction.opposite()[1], coordinate.getY() + direction.opposite()[0]);

        while(isInsideBoard(oppositeCoordinate)
                && this.colors[oppositeCoordinate.getX()][oppositeCoordinate.getY()] == color
        ){
            oppositeCoordinate = oppositeCoordinate.nextOppositeDirection(direction);
        }

        return oppositeCoordinate;
    }

    private boolean isWinnerDirection(ColorEnum color, Coordinate coordinate, DirectionEnum direction){
        int count = 0;
        Coordinate nextCoordinate = new Coordinate(coordinate.getX() + direction.values[1], coordinate.getY() + direction.values[0]);

        while( isInsideBoard(nextCoordinate)
                && this.colors[nextCoordinate.getX()][nextCoordinate.getY()] == color
        ){
            nextCoordinate = nextCoordinate.nextDirection(direction);
            count++;
        }

        return count >= 4;
    }

}
