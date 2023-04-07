class Solution {
    
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int numEnclaves(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count += getClosedEnclaveCount(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    private int getClosedEnclaveCount(int[][] grid, int i, int j, boolean[][] visited) {
        boolean isClosed = true;
        int enclaveCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            enclaveCount++;
            for (int[] dir : DIRS) {
                int newX = removed[0] + dir[0];
                int newY = removed[1] + dir[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    isClosed = false;
                } else if (grid[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return isClosed ? enclaveCount : 0;
    }
}
