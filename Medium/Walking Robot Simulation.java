class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int HASH_MULTIPLIER = 60001;

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
        }
        int maxDistance = 0;
        int currentDirection = 0;
        int x = 0;
        int y = 0;
        for (int command : commands) {
            if (command == -1) {
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
                continue;
            }
            int[] direction = DIRECTIONS[currentDirection];
            for (int i = 0; i < command; i++) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
                    break;
                }
                x = nextX;
                y = nextY;
            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }

    private static int hashCoordinates(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }
}
