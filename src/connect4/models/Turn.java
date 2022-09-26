package connect4.models;

public class Turn {

    private int value;
    private final Player[] players;

    public Turn(Player[] players) {
        this.value = 0;
        this.players = players;
    }

    public void changeTurn() {
        this.value++;
    }

    public Player getCurrentPlayer() {
        return players[this.value % 2];
    }
}
