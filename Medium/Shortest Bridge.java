class Solution {
    
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        List<int[]> queueOne = new ArrayList<>();
        List<int[]> queueTwo = new ArrayList<>();
        queueOne.add(new int[]{x, y});
        queueTwo.add(new int[]{x, y});
        grid[x][y] = 2;
        while (!queueOne.isEmpty()) {
            List<int[]> bfs = new ArrayList<>();
            for (int[] cell : queueOne) {
                int currX = cell[0];
                int currY = cell[1];
                for (int[] dir : DIRS) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        bfs.add(new int[]{newX, newY});
                        queueTwo.add(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                    }
                }
            }
            queueOne = bfs;
        }
        int distance = 0;
        while (!queueTwo.isEmpty()) {
            List<int[]> bfs = new ArrayList<>();
            for (int[] cell : queueTwo) {
                int currX = cell[0];
                int currY = cell[1];
                for (int[] dir : DIRS) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                        if (grid[newX][newY] == 1) {
                            return distance;
                        } else if (grid[newX][newY] == 0) {
                            bfs.add(new int[]{newX, newY});
                            grid[newX][newY] = -1;
                        }
                    }
                }
            }
            queueTwo = bfs;
            distance++;
        }
        return distance;
    }
}

