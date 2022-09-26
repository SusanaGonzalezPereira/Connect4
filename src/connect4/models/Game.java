package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.GameModeEnum;

public class Game {

    private final Board board;
    private final Player[] players;
    private Turn turn;
    private GameModeEnum gameMode;

    public Game() {
        this.board = new Board();
        this.players = new Player[ColorEnum.ALL_BUT_NULL_COLOR.size()];
    }

    public void initializePlayers() {
        switch (this.gameMode) {
            case HUMAN:
                for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
                    players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerHuman(color);
                }
                break;
            case MACHINE:
                for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
                    if (ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color) % 2 == 0) {
                        players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerHuman(ColorEnum.RED);
                    } else {
                        players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerMachine(ColorEnum.BLUE);
                    }
                }
                break;
            case DEMO:
                for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
                    players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerMachine(color);
                }
                break;
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
        this.board.putColumn(coordinate, this.getActiveColor());
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

    public void setGameMode(GameModeEnum gameMode) {
        this.gameMode = gameMode;
    }

    public Turn getTurn() {
        return turn;
    }

    public Coordinate selectCoordinatePoint() {
        return this.getTurn().getCurrentPlayer().selectCoordinatePoint(this);
    }
}
