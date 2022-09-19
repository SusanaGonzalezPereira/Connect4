public class Board {

    private final char[][] grid;

    public Board() {
        this.grid = new char[Connect4.MAX_ROWS][Connect4.MAX_COLUMNS];
        for (int i = 0; i < Connect4.MAX_ROWS; i++) {
            for (int j = 0; j < Connect4.MAX_COLUMNS; j++) {
                this.grid[i][j] = Connect4.EMPTY_VALUE;
            }
        }
    }

    public void show() {
        System.out.println("Board status:");
        for (int i = 0; i < Connect4.MAX_ROWS; i++) {
            for (int j = 0; j < Connect4.MAX_COLUMNS; j++) {
                System.out.print("|" + grid[i][j]);
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
        char previous = Connect4.EMPTY_VALUE;
        for (int i = 0; i < Connect4.MAX_COLUMNS; i++) {
            count = 0;
            for (int j = 0; j < Connect4.MAX_ROWS; j++) {
                char actual = grid[j][i];
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
        char previous = Connect4.EMPTY_VALUE;
        for (int i = 0; i < Connect4.MAX_ROWS; i++) {
            count = 0;
            for (int j = 0; j < Connect4.MAX_COLUMNS; j++) {
                char actual = grid[i][j];
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
        for (int i = 3; i < Connect4.MAX_ROWS; i++) {
            for (int j = 0; j < Connect4.MAX_COLUMNS - 3; j++) {
                if (this.grid[i][j] == tokenType &&
                        this.grid[i - 1][j + 1] == tokenType &&
                        this.grid[i - 2][j + 2] == tokenType &&
                        this.grid[i - 3][j + 3] == tokenType) {
                    System.out.println("Winner at row + " + (i + 1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSolutionInverseDiagonal(char tokenType) {
        for (int i = 0; i < Connect4.MAX_ROWS - 3; i++) {
            for (int j = 0; j < Connect4.MAX_COLUMNS - 3; j++) {
                if (this.grid[i][j] == tokenType &&
                        this.grid[i + 1][j + 1] == tokenType &&
                        this.grid[i + 2][j + 2] == tokenType &&
                        this.grid[i + 3][j + 3] == tokenType) {
                    System.out.println("Winner at row + " + (i + 1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAvailableColumn(int column) {

        if (this.grid[0][column] != Connect4.EMPTY_VALUE) {
            System.out.println("This column is full");
            return false;
        }

        return true;

    }

    public void putColumn(int column, char tokenType) {

        int row = 0;

        for (int i = 0; i < Connect4.MAX_ROWS; i++) {
            if (this.grid[i][column] == Connect4.EMPTY_VALUE) {
                row = i;
            }
        }

        this.grid[row][column] = tokenType;

    }

    public void showDraw() {
        System.out.println("This game ended in a draw!");
    }
}
