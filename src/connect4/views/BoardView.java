package connect4.views;

import connect4.models.Board;
import connect4.utils.ColorEnum;
import connect4.utils.MessageEnum;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void show() {
        MessageEnum.TITLE.writeln();
        for (int i = 0; i < this.board.getMaxRows(); i++) {
            for (int j = 0; j < this.board.getMaxColumns(); j++) {
                MessageEnum.VERTICAL_LINE_WITH_COLOR.write(this.board.getColors()[i][j]);
            }
            MessageEnum.VERTICAL_LINE.writeln();
        }
        MessageEnum.BOARD_INDEX.writeln();
    }

    public void showWinnerMessage(ColorEnum color) {
        MessageEnum.PLAYER_WIN.writeln(color);
    }

    public void showDrawMessage() {
        MessageEnum.GAME_DRAW.writeln();
    }

    public void fullColumn() {
        MessageEnum.FULL_COLUM.writeln();
    }

}
