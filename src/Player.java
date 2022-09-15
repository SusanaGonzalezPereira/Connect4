import java.util.Scanner;

public class Player {

    private Board board;
    private char tokenType;
    
    public Player(Board board, char tokenType) {
        this.board = board;
        this.tokenType = tokenType;
    }

    public void putToken() {

        Coordinate coordinate = new Coordinate();

        do {

            coordinate.askValues();

        }while(!this.board.isAvailableCoordinate(coordinate));

        this.board.putCoordinate(coordinate);



    }
}
