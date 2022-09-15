public class Turn {

    private int turn; //TODO:Preguntar si esta bien

    public Turn() {
        this.turn = 0;
    }

    public int getTurn() {
        return this.turn;
    }
    public void changeTurn() {
        if (this.turn == 0){
            this.turn = 1;
        } else {
            this.turn = 0;
        }
    }
}
