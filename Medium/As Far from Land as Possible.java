class Solution {
    
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == rows * cols) {
            return -1;
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                for (int[] dir : DIRS) {
                    int x = removed[0] + dir[0];
                    int y = removed[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 1) {
                        continue;
                    }
                    grid[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
            distance++;
        }
        return distance - 1;
    }
}
