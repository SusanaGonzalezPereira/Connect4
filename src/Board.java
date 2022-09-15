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
        System.out.println("Tablero actual:");
        for ( int i = 0; i < MAX_ROWS ; i++ ){
            for ( int j = 0; j < MAX_COLUMNS; j++) {
                System.out.print( "|" + map[i][j] );
            }
            System.out.println("|");
        }
        System.out.println("-------------------");
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
}
