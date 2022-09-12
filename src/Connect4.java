public class Connect4 {

    private Board board;
    private Player[] players;
    //private Turn turn;

    public static void main(String args[]) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }

    public void play() {
        int turn = 0;
        do {
            board.show();
            players[turn].putToken(board);
            board.show();
            turn =



        } while (!board.hasWinner());
    }



}
