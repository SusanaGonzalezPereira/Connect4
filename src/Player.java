import java.util.Scanner;

public class Player {

    private Board board;
    private final char tokenType;

    public Player(Board board, char tokenType) {
        this.setBoard(board);
        this.tokenType = tokenType;
    }

    public void putToken() {

        Scanner scanner = new Scanner(System.in);
        int column = 0;

        do {

            try {

                do {
                    System.out.print("Player " + this.tokenType + ". Please insert a column [1-" + Connect4.MAX_COLUMNS + "]:");
                    column = scanner.nextInt();

                } while (column <= 0 || column > Connect4.MAX_COLUMNS);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            column--;

        } while (!this.board.isAvailableColumn(column));

        this.board.putColumn(column, tokenType);

    }

    public void showWinnerMessage() {
        System.out.println("The Player " + this.tokenType + " has won.");
    }

    public char getTokenType() {
        return tokenType;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
