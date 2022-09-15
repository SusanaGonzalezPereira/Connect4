import java.util.Scanner;

public class Coordinate {

    private int row;
    private int col;

    public Coordinate() {
        this.row = 0;
        this.col = 0;
    }


    public Coordinate askValues() {

        Scanner scanner = new Scanner(System.in);

        try{

            do {
                System.out.print("Please insert a row [1-" + Board.MAX_ROWS + "]:");
                this.row = scanner.nextInt();

            }while(this.row <= 0 || this.row > Board.MAX_ROWS);

            do {
                System.out.print("Please insert a col [1-" + Board.MAX_COLUMNS + "]:");
                this.col = scanner.nextInt();

            }while(this.col <= 0 || this.col > Board.MAX_COLUMNS);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        return this;

    }


}
