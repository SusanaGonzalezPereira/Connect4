package connect4;

import connect4.models.Game;
import connect4.utils.GameModeEnum;
import connect4.views.View;

public class Connect4 {

    private Game game;
    private View view;

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
        preguntar cuantos jugadores:
        0 demo
        1 jugador vs maquina
        2 jugador vs jugador
        vista separadas de los modelos -> tecnica del doble despacho ya que cada vista es diferente para un humano y para una maquina
        no controladores
        clase coordenada
        clase direccion
        hasWinner
         */
}
