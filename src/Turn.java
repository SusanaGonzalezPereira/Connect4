public class Turn { //TODO: is it ok have this class or move this login to connect4 since it is simple?
    int turn;
    public int getTurn() {
        return turn;
    }
    public int updateTurn() { //TODO: discuss is ok to return an int here and delete getTurn() ?
        if (turn == 1) {
            turn = 0;
        } else {
            turn = 1;
        }
        return turn;
    }
}
