class Solution {

    private static final int[] DIRS = {-1, 0, 1};

    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            visited[i][0] = true;
            queue.add(new int[]{i, 0, 0});
        }
        int result = 0; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                int row = removed[0];
                int col = removed[1];
                int count = removed[2];
                result = Math.max(result, count);
                for (int dir : DIRS) {
                    int nextRow = row + dir;
                    int nextCol = col + 1;
                    if (nextRow >= 0 && 
                        nextCol >= 0 && 
                        nextRow < rows && 
                        nextCol < cols && 
                        !visited[nextRow][nextCol] &&
                        grid[row][col] < grid[nextRow][nextCol]) {
                            visited[nextRow][nextCol] = true;
                            queue.add(new int[]{nextRow, nextCol, count + 1});
                        }
                }
            }
        }
        return result;
    }
}
