class Solution {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && isClosed(grid, i, j, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isClosed(int[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        boolean closed = true;
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            for (int[] dir : DIRS) {
                int newX = removed[0] + dir[0];
                int newY = removed[1] + dir[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    closed = false;
                } else if (grid[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return closed;
    }
}
