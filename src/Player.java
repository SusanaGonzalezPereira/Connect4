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
        int column = 0;

        do {

            try{

                do {
                    System.out.print("Please insert a col [1-" + Board.MAX_COLUMNS + "]:");
                    column = scanner.nextInt();

                }while(column <= 0 || column > Board.MAX_COLUMNS);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            column--;

        }while(!this.board.isAvailableColumn(column));

        this.board.putColumn(column, tokenType);

    }
}
