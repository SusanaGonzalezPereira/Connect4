package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.GameModeEnum;

public class Game {

    private final Board board;
    private final Player[] players;
    private final Turn turn;
    private GameModeEnum gameMode;

    public Game() {
        this.board = new Board();
        this.players = new Player[ColorEnum.ALL_BUT_NULL_COLOR.size()];
        for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
            players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new Player(color, this.board);
        }
        this.turn = new Turn(this.players);
    }

    public void changeTurn() {
        this.turn.changeTurn();
    }

    public ColorEnum getActiveColor() {
        return this.turn.getCurrentPlayer().getColor();
    }

    public boolean hasWinner() {
        return this.board.hasWinner(this.turn.getCurrentPlayer().getColor());
    }

    public boolean isFull() {
        return this.board.isFull();
    }

    public void putColor(Coordinate coordinate) {
        this.turn.getCurrentPlayer().putColor(coordinate);
    }

    public Board getBoard() {
        return board;
    }

    public boolean isAvailableCoordinate(Coordinate coordinate) {
        return this.board.isAvailableCoordinate(coordinate);
    }

    public boolean isAvailableColumn(int column) {
        return this.board.isAvailableColumn(column);
    }

    public boolean isOnBoard(int column) {
        return this.board.isOnBoard(column);
    }

    public int getMaxColumns() {
        return this.board.getMaxColumns();
    }

    public GameModeEnum getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameModeEnum gameMode) {
        this.gameMode = gameMode;
    }
}
