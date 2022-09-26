package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Interval;
import connect4.views.BoardView;

import java.util.Arrays;

public class Board {

    private final int maxRows = 6;
    private final int maxColumns = 7;
    private final ColorEnum[][] colors;
    private BoardView boardView;

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

    public boolean isAvailableColumn(int column) {
        if (this.colors[0][column] != ColorEnum.NULLCOLOR) {
            System.out.println("This column is full");
            return false;
        }
        return true;
    }

    public void putColumn(int column, ColorEnum tokenType) {
        int i = maxRows-1;
        while(this.colors[i][column] != ColorEnum.NULLCOLOR){
            i--;
        }
        this.colors[i][column] = tokenType;
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
}
