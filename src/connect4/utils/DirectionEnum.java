package connect4.utils;

public enum DirectionEnum {

    NORTH(new int[]{0, -1}),
    WEST(new int[]{-1, 0}),
    SOUTH(new int[]{0, 1}),
    EAST(new int[]{1, 0}),
    NORTH_WEST(new int[]{-1, -1}),
    NORTH_EAST(new int[]{1, -1}),
    SOUTH_WEST(new int[]{-1, 1}),
    SOUTH_EAST(new int[]{1, 1});
    public final int[] values;

    DirectionEnum(int[] values) {
        this.values = values;
    }

    public int[] opposite() {
        int[] inverse = new int[2];
        inverse[0] = this.values[0] * -1;
        inverse[1] = this.values[1] * -1;
        return inverse;
    }


}
