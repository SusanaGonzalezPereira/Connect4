package connect4;

import connect4.models.Game;
import connect4.views.View;

public class Connect4 {

    private final Game game;
    private final View view;

    public Connect4() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

    private void play() {
        this.view.showMenu();
        this.view.start();
        this.view.play();
    }

    /*
        clase coordenada
        clase direccion
        hasWinner
         */
}
