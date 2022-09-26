package connect4.models;

import connect4.utils.ColorEnum;
import connect4.views.BoardView;

public class Connect4 {

    //coordenada - objeto
    //direccion - objeto
    //puntos cardinales - enum

    private final Board board;
    private final Player[] players;
    private final Turn turn;
    private final BoardView boardView;

    public Connect4() {
        this.board = new Board();
        this.players = new Player[ColorEnum.ALL_BUT_NULL_COLOR.size()];
        for(ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR){
            players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new Player(color, this.board);
        }
        this.turn = new Turn(this.players);
        this.boardView = new BoardView(this.board);

        /*
        preguntar cuantos jugadores:
        0 demo
        1 jugador vs maquina
        2 jugador vs jugador
        vista separadas de los modelos -> tecnica del doble despacho ya que cada vista es diferente para un humano y para una maquina
        no controladores
        clase coordenada
        clase direccion
         */
    }

    public void play() {
        boolean hasWinner;
        this.boardView.show();
        do {
            this.turn.getCurrentPlayer().putColor();
            boardView.show();
            hasWinner = this.board.hasWinner(this.turn.getCurrentPlayer().getColor());
            if (!hasWinner) {
                this.turn.changeTurn();
            }
        } while (!hasWinner && !this.board.isFull());

        if (hasWinner) {
            this.boardView.showWinnerMessage(this.turn.getCurrentPlayer().getColor());
        } else {
            this.boardView.showDrawMessage();
        }
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
