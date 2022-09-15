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
        int row = 0;
        int col = 0;

        try{

            do {
                System.out.print("Please insert a row [1-6]:");
                row = scanner.nextInt();

            }while(!this.board.isAvailableRow(row));

            do {
                System.out.print("Please insert a col [1-7]:");
                col = scanner.nextInt();

            }while(!this.board.isAvailableCol(col));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
