package connect4.views;

import connect4.models.Game;
import connect4.utils.Coordinate;
import connect4.utils.MessageEnum;

import java.util.Scanner;

public class PlayerView {

    private Game game;

    public PlayerView(Game game) {
        this.game = game;
    }

    public void interact() {
        if (!this.game.isFull()) {
            this.putColor();
        }
    }

    private void putColor() {
        Coordinate coordinate;
        do {
            coordinate = this.getCoordinate(MessageEnum.INSERT_COLOR);
        } while (!this.game.isAvailableCoordinate(coordinate));
        this.game.putColor(coordinate);
    }

    Coordinate getCoordinate(MessageEnum message) {
        assert message != null;

        Scanner scanner = new Scanner(System.in);
        int column = 0;
        try {
            do {
                message.write(this.game.getMaxColumns(), this.game.getActiveColor().toString());
                column = scanner.nextInt();
                column--;
                if (!this.game.isAvailableColumn(column)) {
                    MessageEnum.FULL_COLUM.writeln();
                }
            } while (!this.game.isAvailableColumn(column) || !this.game.isOnBoard(column));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Coordinate(column, this.game.getBoard());
    }

}
