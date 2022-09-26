package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.MessageEnum;

public class PlayerMachine extends Player {
    public PlayerMachine(ColorEnum color) {
        super(color);
    }

    @Override
    public Coordinate selectCoordinatePoint(Game game) {

        int column;
        do {
            column = (int) (Math.random() * (game.getMaxColumns()));
        } while (!game.isAvailableColumn(column) || !game.isOnBoard(column));

        Coordinate coordinate = new Coordinate(column, game.getBoard());
        MessageEnum.MACHINE_MESSAGE.writeln(game.getActiveColor().toString(), coordinate);

        return coordinate;
    }
}
