public class Board {

    protected static int MAX_ROWS = 6;
    protected static int MAX_COLUMNS = 7;
    protected static char EMPTY_VALUE = '-';
    private final char[][] map;

    public Board() {
        this.map = new char[MAX_ROWS][MAX_COLUMNS];
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                this.map[i][j] = EMPTY_VALUE;
            }
        }
    }

    public void show() {
        System.out.println("Board status:");
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("|1|2|3|4|5|6|7|");
    }

    public boolean hasWinner(char tokenType) {
        return isSolutionColumn(tokenType) || isSolutionDiagonal(tokenType) || isSolutionInverseDiagonal(tokenType) || isSolutionRow(tokenType);
    }

    private boolean isSolutionColumn(char tokenType) {
        int count;
        char previous = EMPTY_VALUE;
        for (int i = 0; i < MAX_COLUMNS; i++) {
            count = 0;
            for (int j = 0; j < MAX_ROWS; j++) {
                char actual = map[j][i];
                if (actual == previous && actual == tokenType) {
                    count++;
                    if (count >= 3) {
                        System.out.println("Winner at column " + (i + 1));
                        return true;
                    }
                } else {
                    previous = actual;
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean isSolutionRow(char tokenType) {
        int count;
        char previous = EMPTY_VALUE;
        for (int i = 0; i < MAX_ROWS; i++) {
            count = 0;
            for (int j = 0; j < MAX_COLUMNS; j++) {
                char actual = map[i][j];
                if (actual == previous && actual == tokenType) {
                    count++;
                    if (count >= 3) {
                        System.out.println("Winner at row + " + (i + 1));
                        return true;
                    }
                } else {
                    previous = actual;
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean isSolutionDiagonal(char tokenType) {
        for (int i = 3; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS - 3; j++) {
                if (this.map[i][j] == tokenType &&
                        this.map[i - 1][j + 1] == tokenType &&
                        this.map[i - 2][j + 2] == tokenType &&
                        this.map[i - 3][j + 3] == tokenType) {
                    System.out.println("Winner at row + " + (i + 1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSolutionInverseDiagonal(char tokenType) {
        for (int i = 0; i < MAX_ROWS - 3; i++) {
            for (int j = 0; j < MAX_COLUMNS - 3; j++) {
                if (this.map[i][j] == tokenType &&
                        this.map[i + 1][j + 1] == tokenType &&
                        this.map[i + 2][j + 2] == tokenType &&
                        this.map[i + 3][j + 3] == tokenType) {
                    System.out.println("Winner at row + " + (i + 1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAvailableColumn(int column) {

        if (this.map[0][column] != EMPTY_VALUE) {
            System.out.println("This column is full");
            return false;
        }

        return true;

    }

    public void putColumn(int column, char tokenType) {

        int row = 0;

        for (int i = 0; i < MAX_ROWS; i++) {
            if (this.map[i][column] == EMPTY_VALUE) {
                row = i;
            }
        }

        this.map[row][column] = tokenType;

    }

    public void showDraw() {
        System.out.println("This game ended in a draw!");
    }
}
