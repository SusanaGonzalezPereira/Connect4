package connect4.models;

import connect4.models.Player;

public class Turn {

    private int value;
    private Player[] players;

    public Turn(Player[] players) {
        this.value = 0;
        this.players = players;
    }

    public void changeTurn() {
        this.value++;
    }

    public Player getCurrentPlayer(){
       return players[this.value % 2];
    }
}
