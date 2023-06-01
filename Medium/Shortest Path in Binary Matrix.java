class Solution {
    
    private static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        if (grid[0][0] == 1 || grid[numRows - 1][numCols - 1] == 1) {
            return -1;
        }
        int shortestDistance = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[numRows][numCols];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                if (removed[0] == (numRows - 1) && removed[1] == (numCols - 1)) {
                    return shortestDistance + 1;
                }
                for (int i = 0; i < DIRS.length; i++) {
                    int newX = removed[0] + DIRS[i][0];
                    int newY = removed[1] + DIRS[i][1];
                    if (isValidCoordinate(newX, newY, numRows, numCols, visited, grid)) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            shortestDistance++;
        }
        return -1;
    }
    
    private static boolean isValidCoordinate(int x, int y, int rows, int cols, boolean[][] visited, int[][] grid) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0;
    }
}
