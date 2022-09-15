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
        for ( int i = 0; i < MAX_ROWS ; i++ ){
            for ( int j = 0; j < MAX_COLUMNS; j++) {
                System.out.println( "|" + map[i][j] );
            }
        }
    }

    public boolean hasWinner() {
        return false;
    }
}
