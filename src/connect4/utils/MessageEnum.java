package connect4.utils;

public enum MessageEnum {

    TITLE("Board Status:"),
    VERTICAL_LINE("|"),
    VERTICAL_LINE_WITH_COLOR("|#color"),
    FULL_COLUM("This column is full"),
    PLAYER_WIN("The Player #player has won."),
    GAME_DRAW("This game ended in a draw!"),
    INSERT_COLOR("Player #player. Please insert a column [1-#maxColumn]: "),
    BOARD_INDEX("|1|2|3|4|5|6|7|");

    private String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public void write() {
        System.out.print(this.message);
    }

    public void writeln() {
        System.out.println(this.message);
    }

    public void writeln(ColorEnum color) {
        assert this == MessageEnum.PLAYER_WIN;
        System.out.println(this.message.replaceAll("#player", "" + color));
    }

    public void write(String maxColumn, String player) {
        System.out.println(this.message.replaceAll("#player", "" + player).replaceAll("#maxColumn", "" + maxColumn));
    }

    public void write(ColorEnum color){
        System.out.print(this.message.replaceAll("#color", "" + color));
    }

    @Override
    public String toString() {
        return message;
    }
}
