import java.util.Scanner;

public class Player {

    private Board board;
    private char tokenType;
    
    public Player(Board board, char tokenType) {
        this.board = board;
        this.tokenType = tokenType;
    }

    public void putToken() {

        Scanner scanner = new Scanner(System.in);
        Coordinate coordinate = new Coordinate();

        try{

            do {

                coordinate.askValues();

            }while(!this.board.isAvailableCoordinate(coordinate));

            this.board.putCoordinate(coordinate);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
