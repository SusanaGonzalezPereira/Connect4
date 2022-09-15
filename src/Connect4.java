public class Connect4 {

    private Board board;
    private Player[] players;
    private Turn turn;

    public Connect4() {
        this.board = new Board();
        this.players = new Player[2];
        players[0] = new Player(this.board, 'x');
        players[1] = new Player(this.board, 'O');
        this.turn = new Turn();
    }

    public void play() {

        boolean hasWinner = false;
        do {
            board.show();
            players[turn.getTurn()].putToken();
            hasWinner = board.hasWinner();

            if(!hasWinner) {
                turn.changeTurn();
            }

        } while (!hasWinner);

        board.show();

        players[turn.getTurn()].showWinnerMessage();
    }

    public static void main(String args[]) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }
}
