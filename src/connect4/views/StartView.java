package connect4.views;

import connect4.models.Game;
import connect4.utils.MessageEnum;

class StartView extends WithGameView {

    public StartView(Game game) {
        super(game);
    }

    public void interact() {
        MessageEnum.TITLE.writeln();
        new BoardView().show(this.game);
    }

}