package connect4.views;

import connect4.models.Game;

public class View extends WithGameView {

    private final MenuView menuView;
    private final StartView startView;
    private final PlayView playView;

    public View(Game game) {
        super(game);
        this.menuView = new MenuView(this.game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
    }

    public void showMenu() {
        this.menuView.interact();
    }

    public void start() {
        this.startView.interact();
    }

    public void play() {
        this.playView.interact();
    }

}
