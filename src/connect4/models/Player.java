package connect4.models;

import connect4.utils.ColorEnum;

import java.util.Scanner;

public class Player {

    private final Board board;
    private final ColorEnum color;

    public Player(ColorEnum color, Board board) {
        this.board = board;
        this.color = color;
    }

    public void putColor() {
        Scanner scanner = new Scanner(System.in);
        int column = 0;
        do {
            try {
                do {
                    System.out.print("Player " + this.color + ". Please insert a column [1-" + this.board.getMaxColumns() + "]:");
                    column = scanner.nextInt();
                    column--;
                } while (!this.board.isOnBoard(column));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!this.board.isAvailableColumn(column));
        this.board.putColumn(column, color);
    }

    public ColorEnum getColor() {
        return color;
    }
}
