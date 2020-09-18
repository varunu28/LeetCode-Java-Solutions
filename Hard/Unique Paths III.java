class Solution {
    int numOfPaths;

    public int uniquePathsIII(int[][] grid) {
        numOfPaths = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return numOfPaths;
        }

        int startX = -1;
        int startY = -1;
        int emptyObstacleCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptyObstacleCount++;
                }
            }
        }

        dfsHelper(grid, startX, startY, emptyObstacleCount, 0, new boolean[grid.length][grid[0].length]);

        return numOfPaths;
    }

    private void dfsHelper(int[][] grid,
                           int startX,
                           int startY,
                           int emptyObstacleCount,
                           int currObstacleCount,
                           boolean[][] visited) {
        if (startX < 0 ||
                startX >= grid.length ||
                startY < 0 ||
                startY >= grid[0].length ||
                visited[startX][startY] ||
                grid[startX][startY] == -1) {
            return;
        }

        if (grid[startX][startY] == 2) {
            if (currObstacleCount == emptyObstacleCount) {
                numOfPaths++;
            }

            return;
        }

        visited[startX][startY] = true;

        dfsHelper(grid, startX + 1, startY, emptyObstacleCount,
                grid[startX][startY] == 0 ? currObstacleCount + 1 : currObstacleCount, visited);
        dfsHelper(grid, startX - 1, startY, emptyObstacleCount,
                grid[startX][startY] == 0 ? currObstacleCount + 1 : currObstacleCount, visited);
        dfsHelper(grid, startX, startY + 1, emptyObstacleCount,
                grid[startX][startY] == 0 ? currObstacleCount + 1 : currObstacleCount, visited);
        dfsHelper(grid, startX, startY - 1, emptyObstacleCount,
                grid[startX][startY] == 0 ? currObstacleCount + 1 : currObstacleCount, visited);

        visited[startX][startY] = false;
    }
}
