class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 2) {
                    int key = numCols * i + j;
                    queue.add(key);
                    map.put(key, 0);
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int key = queue.remove();
            int x = key / numCols;
            int y = key % numCols;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= numRows || newY < 0 || newY >= numCols || grid[newX][newY] != 1) {
                    continue;
                }
                grid[newX][newY] = 2;
                int newKey = newX * numCols + newY;
                queue.add(newKey);
                map.put(newKey, map.get(key) + 1);
                ans = map.get(newKey);
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
