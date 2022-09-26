package connect4.views;

import connect4.models.Game;
import connect4.utils.MessageEnum;

public class PlayView extends WithGameView {

    public PlayView(Game game) {
        super(game);
    }

    public void interact() {

        boolean hasWinner;

        do {
            new PlayerView(this.game).interact();

            hasWinner = this.game.hasWinner();
            if (!hasWinner) {
                this.game.changeTurn();
            }
            new BoardView().show(this.game);
        } while (!this.game.hasWinner() && !this.game.isFull());

        if (hasWinner) {
            MessageEnum.PLAYER_WIN.writeln(this.game.getActiveColor());
        } else {
            MessageEnum.GAME_DRAW.writeln();
        }

    }

}
