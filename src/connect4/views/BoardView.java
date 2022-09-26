package connect4.views;

import connect4.models.Game;
import connect4.utils.MessageEnum;

public class BoardView {

    public void show(Game game) {
        for (int i = 0; i < game.getBoard().getMaxRows(); i++) {
            for (int j = 0; j < game.getBoard().getMaxColumns(); j++) {
                MessageEnum.VERTICAL_LINE_WITH_COLOR.write(game.getBoard().getColors()[i][j]);
            }
            MessageEnum.VERTICAL_LINE.writeln();
        }
        MessageEnum.BOARD_INDEX.writeln();
    }

}
