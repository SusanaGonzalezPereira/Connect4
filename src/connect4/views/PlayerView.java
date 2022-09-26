package connect4.views;

import connect4.models.Game;
import connect4.utils.Coordinate;

public class PlayerView {

    protected Game game;

    public PlayerView(Game game) {
        this.game = game;
    }

    private void putColor() {
        Coordinate coordinate;
        do {
            coordinate = this.game.selectCoordinatePoint();
        } while (!this.game.isAvailableCoordinate(coordinate));
        this.game.putColor(coordinate);
    }

    public void interact() {
        if (!this.game.isFull()) {
            this.putColor();
        }
    }


}
