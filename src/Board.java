public class Board {

    private char map [][];
    private static int MAX_ROWS = 6;
    private static int MAX_COLUMNS = 7;

    public Board() {
        this.map = new char[MAX_ROWS][MAX_COLUMNS];
        for ( int i = 0; i < MAX_ROWS ; i++ ){
            for ( int j = 0; j < MAX_COLUMNS; j++) {
                this.map[i][j] = '-';
            }
        }
    }

    public void show() {
        System.out.println("Board status:");
        for ( int i = 0; i < MAX_ROWS ; i++ ){
            System.out.print("|" +  (i+1) + "|\t");
            for ( int j = 0; j < MAX_COLUMNS; j++) {
                System.out.print("|" + map[i][j] );
            }
            System.out.println("|");
        }
        System.out.println("|0|\t|1|2|3|4|5|6|7|");
    }

    public boolean hasWinner() {
        return isSolutionColumn() || isSolutionDiagonal() || isSolutionInverseDiagonal() || isSolutionRow();
    }

    private boolean isSolutionColumn(){
        //TODO:Implementar
        return true;

    }

    private boolean isSolutionRow() {
        //TODO:Implementar
        return true;
    }

    private boolean isSolutionDiagonal(){
        //TODO:Implementar
        return true;
    }

    private boolean isSolutionInverseDiagonal() {
        //TODO:Implementar
        return true;
    }

    public boolean isAvailableRow(int row) {
    }

    public boolean isAvailableCol(int col) {
    }
}
