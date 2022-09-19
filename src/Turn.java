public class Turn {

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
        return turn == Connect4.MAX_TURNS;
    }
}
