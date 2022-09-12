public class Connect4 {

    private Board board;
    private Player[] players;
    private Turn turn;

    public static void main(String args[]) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }

    public Connect4() {
        this.board = new Board();
        this.players = new Player[2]; //TODO: discuss if we want to initiallize players here (put TokenType etc)
        this.turn = new Turn();
    }

    public void play() {
        do {
            board.show();
            players[turn.getTurn()].putToken(board);
            board.show();
            turn.updateTurn();

        } while (!board.hasWinner());

        board.showWinnerMessage();
    }



}
