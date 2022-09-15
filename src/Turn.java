public class Turn {

    private final int MAX_TURNS = (Board.MAX_ROWS * Board.MAX_COLUMNS) - 1;
    private int turn; //TODO: Ask if this is ok

    public Turn() {
        this.turn = 0;
    }

    public int getTurn() {
        return this.turn % 2;
    }

    public void changeTurn() {
        this.turn++;
    }

    public boolean isDraw() {
        return turn == MAX_TURNS;
    }
}
