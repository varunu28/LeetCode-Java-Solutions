class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int entranceRow = entrance[0];
        int entranceCol = entrance[1];
        queue.add(new int[]{entranceRow, entranceCol});
        visited[entranceRow][entranceCol] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                int row = removed[0];
                int col = removed[1];
                if (!(row == entranceRow && col == entranceCol) && isExit(row, col, rows, cols)) {
                    return steps;
                }
                for (int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && 
                        newCol >= 0 && 
                        newRow < rows && 
                        newCol < cols && 
                        !visited[newRow][newCol] &&
                        maze[newRow][newCol] != '+') {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private boolean isExit(int row, int col, int rows, int cols) {
        return (row + 1 == rows) || (row - 1 == -1) || (col + 1 == cols) || (col - 1 == -1);
    }
}
