package connect4.models;

import connect4.utils.ColorEnum;
import connect4.utils.Coordinate;
import connect4.utils.MessageEnum;

import java.util.Scanner;

public class PlayerHuman extends Player {

    public PlayerHuman(ColorEnum color) {
        super(color);
    }

    @Override
    public Coordinate selectCoordinatePoint(Game game) {
        Scanner scanner = new Scanner(System.in);
        int column = 0;
        try {
            do {
                MessageEnum.INSERT_COLOR.write(game.getMaxColumns(), game.getActiveColor().toString());
                column = scanner.nextInt();
                column--;
                if (!game.isAvailableColumn(column)) {
                    MessageEnum.FULL_COLUM.writeln();
                }
            } while (!game.isAvailableColumn(column) || !game.isOnBoard(column));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Coordinate(column, game.getBoard());
    }
}
