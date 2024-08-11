class Solution {

    private static final Map<String, int[]> COMMAND_TO_DIRECTION = Map.of(
        "UP", new int[]{-1, 0},
        "DOWN", new int[]{1, 0},
        "LEFT", new int[]{0, -1},
        "RIGHT", new int[]{0, 1}
    );

    public int finalPositionOfSnake(int n, List<String> commands) {
        int position = 0;
        int x = 0;
        int y = 0;
        for (String command : commands) {
            int[] change = COMMAND_TO_DIRECTION.get(command);
            x += change[0];
            y += change[1];
            position = x * n + y;
        }
        return position;
    }
}
