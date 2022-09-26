package connect4.views;

import connect4.models.Game;
import connect4.utils.GameModeEnum;
import connect4.utils.Interval;
import connect4.utils.MessageEnum;

import java.util.Scanner;

public class MenuView extends WithGameView{
    public MenuView(Game game) {
        super(game);
    }

    public void interact() {
        MessageEnum.WELCOME.writeln();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try {
            do {
                MessageEnum.GAME_MODES.writeln();
                option = scanner.nextInt();
                option--;
            } while (!new Interval(-1,3).isBetweenExclusive(option));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.game.setGameMode(GameModeEnum.values()[option]);
    }
}
