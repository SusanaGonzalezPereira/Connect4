package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.DirectionEnum;
import connect4.utils.GameModeEnum;

import java.util.EnumSet;
import java.util.Iterator;

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
            case HUMAN -> this.initializeHuman();
            case MACHINE -> this.initializeMachine();
            case DEMO -> this.initializeDemo();
        }
        this.turn = new Turn(this.players);
    }

    public void changeTurn() {
        this.turn.changeTurn();
    }

    public ColorEnum getActiveColor() {
        return this.turn.getCurrentPlayer().getColor();
    }

    public boolean hasWinner(Coordinate coordinate) {
        boolean win;
        Iterator<DirectionEnum> iterator = EnumSet.allOf(DirectionEnum.class).iterator();

        do {
            win = this.board.hasWinner(this.getActiveColor(), coordinate, iterator.next());
        } while (!win && iterator.hasNext());

        return win;
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

    private void initializeHuman() {
        for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
            this.players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerHuman(color);
        }
    }

    private void initializeMachine() {
        for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
            if (ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color) % 2 == 0) {
                this.players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerHuman(ColorEnum.RED);
            } else {
                this.players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerMachine(ColorEnum.BLUE);
            }
        }
    }

    private void initializeDemo() {
        for (ColorEnum color : ColorEnum.ALL_BUT_NULL_COLOR) {
            this.players[ColorEnum.ALL_BUT_NULL_COLOR.indexOf(color)] = new PlayerMachine(color);
        }
    }
}
