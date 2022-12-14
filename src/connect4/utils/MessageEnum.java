package connect4.utils;

public enum MessageEnum {

    TITLE("Board Status:"),
    VERTICAL_LINE("|"),
    VERTICAL_LINE_WITH_COLOR("|#color"),
    CHOOSE_OTHER_COLUMN("Choose another column."),
    PLAYER_WIN("The Player #player has won."),
    GAME_DRAW("This game ended in a draw!"),
    INSERT_COLOR("#player Player. Please insert a column [1-#maxColumn]: "),
    WELCOME("WELCOME"),
    GAME_MODES("Please choose one of the following game modes: \n 1. Two Players \n 2. Player VS Machine \n 3. Demo"),
    MACHINE_MESSAGE("#player Machine has chosen Coordinate: { row: #x, column: #y}"),
    ERROR("#error"),
    BOARD_INDEX("|1|2|3|4|5|6|7|");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public void writeln() {
        System.out.println(this.message);
    }

    public void writeln(ColorEnum color) {
        assert this == MessageEnum.PLAYER_WIN;
        System.out.println(this.message.replaceAll("#player", "" + color));
    }

    public void writeln(String error) {
        System.out.println(this.message.replaceAll("#error", "" + error));
    }

    public void writeln(String player, Coordinate coordinate) {
        System.out.println(this.message.replaceAll("#player", "" + player)
                .replaceAll("#x", "" + (coordinate.getX() + 1))
                .replaceAll("#y", "" + (coordinate.getY() + 1)));
    }


    public void write(ColorEnum color) {
        System.out.print(this.message.replaceAll("#color", "" + color));
    }

    public void write(int maxColumn, String player) {
        System.out.print(this.message.replaceAll("#player", "" + player)
                .replaceAll("#maxColumn", "" + maxColumn));
    }

    @Override
    public String toString() {
        return message;
    }
}
