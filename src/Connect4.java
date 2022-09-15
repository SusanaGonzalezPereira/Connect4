public class Connect4 {

    private final Board board;
    private final Player[] players;
    private final Turn turn;

    public Connect4() {
        this.board = new Board();
        this.players = new Player[2];
        players[0] = new Player(this.board, 'x');
        players[1] = new Player(this.board, 'O');
        this.turn = new Turn();
    }

    public void play() {

        boolean hasWinner;
        do {
            board.show();
            players[turn.getTurn()].putToken();
            hasWinner = board.hasWinner();

            if (!hasWinner) {
                turn.changeTurn();
            }

        } while (!hasWinner && !turn.isDraw());

        board.show();
        if (hasWinner) {
            players[turn.getTurn()].showWinnerMessage();
        } else {
            board.showDraw();
        }

    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
