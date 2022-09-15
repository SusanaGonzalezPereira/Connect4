public class Connect4 {

    private Board board;
    private Player[] players;
    private Turn turn;

    public Connect4() {
        this.board = new Board();
        this.players = new Player[2];
        for (int i = 0; i < 2; i++) {
            players[i] = new Player(this.board, 'x');
        }
        this.turn = new Turn();
    }

    public void play() {
        do {
            board.show();
            players[turn.getTurn()].putToken();
            turn.changeTurn();
        } while (!board.hasWinner());

        board.show();
    }

    public static void main(String args[]) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }
}
